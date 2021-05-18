package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import ru.inversion.customers2.pojo.PCus_Docum;
import ru.inversion.dataset.IDataSet;
import ru.inversion.dataset.XXIDataSet;
import ru.inversion.dataset.fx.DSFXAdapter;
import ru.inversion.fx.form.ActionFactory;
import ru.inversion.fx.form.FXFormLauncher;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.JInvFXFormController;
import ru.inversion.fx.form.controls.JInvTable;
import ru.inversion.fx.form.controls.JInvToolBar;
import ru.inversion.meta.EntityMetadataFactory;
import ru.inversion.meta.IEntityProperty;

public class CUS_DOCUMController extends JInvFXBrowserController {

    @FXML private JInvToolBar toolBarDocum;
    @FXML private JInvTable<PCus_Docum> cus_doc;
    private XXIDataSet<PCus_Docum> dsPcus = new XXIDataSet<>();


    @Override
    protected void init() throws Exception {
        setTitle("Таблица Customers");
        initDataSet();
        DSFXAdapter<PCus_Docum> dsfx = DSFXAdapter.bind(dsPcus, cus_doc, null, false);
//        dsfx.setEnableFilter(true);
        initToolBar();
        doRefresh();
        cus_doc.setToolBar(toolBarDocum);
        cus_doc.setAction(ActionFactory.ActionTypeEnum.CREATE, a -> doOperation(FormModeEnum.VM_INS));
        cus_doc.setAction(ActionFactory.ActionTypeEnum.CREATE_BY, a -> doOperation(FormModeEnum.VM_NONE));
        cus_doc.setAction(ActionFactory.ActionTypeEnum.VIEW, a -> doOperation(FormModeEnum.VM_SHOW));
        cus_doc.setAction(ActionFactory.ActionTypeEnum.UPDATE, a -> doOperation(FormModeEnum.VM_EDIT));
        cus_doc.setAction(ActionFactory.ActionTypeEnum.DELETE, a -> doOperation(FormModeEnum.VM_DEL));
        cus_doc.setAction(ActionFactory.ActionTypeEnum.REFRESH, a -> doRefresh());
    }

    private void initDataSet() {
        dsPcus.setTaskContext(getTaskContext());
        dsPcus.setRowClass(PCus_Docum.class);
    }

    private void initToolBar() {
        toolBarDocum.setStandartActions(ActionFactory.ActionTypeEnum.CREATE,
                ActionFactory.ActionTypeEnum.CREATE_BY,
                ActionFactory.ActionTypeEnum.VIEW,
                ActionFactory.ActionTypeEnum.UPDATE,
                ActionFactory.ActionTypeEnum.DELETE,
                ActionFactory.ActionTypeEnum.REFRESH);
    }

    private void doOperation(FormModeEnum mode) {
        PCus_Docum customers = null;
        switch (mode) {
            case VM_INS:
                customers = new PCus_Docum();
                break;
            case VM_NONE:
                if (dsPcus.getCurrentRow() == null)
                    break;
                    mode = FormModeEnum.VM_INS;
                    customers = new PCus_Docum();
                    for (IEntityProperty<PCus_Docum, ?> value : EntityMetadataFactory.getEntityMetaData(PCus_Docum.class)
                            .getPropertiesMap().values()) {
                        if (!(value.isTransient() || value.isId()))
                            value.invokeSetter(customers, value.invokeGetter(dsPcus.getCurrentRow()));
                        break;
                    }
            case VM_EDIT:
            case VM_SHOW:
            case VM_DEL:
                customers = dsPcus.getCurrentRow();
                break;
        }
        if (customers != null) {
            new FXFormLauncher<>(this, EditCus_DocumController.class)
                    .dataObject(customers)
                    .dialogMode(mode)
                    .initProperties(getInitProperties())
                    .callback(this::doFormResult)
                    .doModal();
        }
    }

    private void doFormResult(FormReturnEnum ok, JInvFXFormController<PCus_Docum> dctl) {
        if (FormReturnEnum.RET_OK == ok) {
            switch (dctl.getFormMode()) {
                case VM_INS:
                    dsPcus.insertRow(dctl.getDataObject(), IDataSet.InsertRowModeEnum.AFTER_CURRENT, true);
                    break;
                case VM_EDIT:
                    dsPcus.updateCurrentRow(dctl.getDataObject());
                    break;
                case VM_DEL:
                    dsPcus.removeCurrentRow();
                    break;
                default:
                    break;
            }
        }
        cus_doc.requestFocus();
    }

    private void doRefresh() {
        cus_doc.executeQuery();
    }
}
