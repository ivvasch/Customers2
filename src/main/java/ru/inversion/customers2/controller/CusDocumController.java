package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import ru.inversion.customers2.pojo.PCusDocum;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.customers2.service.AllDataSet;
import ru.inversion.dataset.DataLinkBuilder;
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

public class CusDocumController extends JInvFXBrowserController {

    @FXML private JInvToolBar toolBarDocum;
    @FXML private JInvTable<PCusDocum> cus_doc;
    private XXIDataSet<PCusDocum> dsPcusDoc = new XXIDataSet<>();
    private AllDataSet dataSet;


    protected void init(AllDataSet dataSet) throws Exception {
        this.dataSet = dataSet;
        setTitle("Таблица Документы клиента");
        initDataSet();
        DSFXAdapter<PCusDocum> dsfx = DSFXAdapter.bind(dsPcusDoc, cus_doc, null, false);
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
        dataSet.setDocController(this);
        dsPcusDoc = dataSet.getDsPcusDoc();
        DataLinkBuilder.linkDataSet(dataSet.getDsPcus(), dataSet.getDsPcusAddr(), PCustomers::getICUSNUM, "ICUSNUM");
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
        PCusDocum customers = null;
        switch (mode) {
            case VM_INS:
                customers = new PCusDocum();
                customers.setICUSNUM(dsPcusDoc.getCurrentRow().getICUSNUM());
                break;
            case VM_NONE:
                if (dsPcusDoc.getCurrentRow() == null)
                    break;
                    mode = FormModeEnum.VM_INS;
                    customers = new PCusDocum();
                    for (IEntityProperty<PCusDocum, ?> value : EntityMetadataFactory.getEntityMetaData(PCusDocum.class)
                            .getPropertiesMap().values()) {
                        if (!(value.isTransient() || value.isId()))
                            value.invokeSetter(customers, value.invokeGetter(dsPcusDoc.getCurrentRow()));
                        break;
                    }
            case VM_EDIT:
            case VM_SHOW:
            case VM_DEL:
                customers = dsPcusDoc.getCurrentRow();
                break;
        }
        if (customers != null) {
            new FXFormLauncher<>(this, EditCusDocumController.class)
                    .dataObject(customers)
                    .dialogMode(mode)
                    .initProperties(getInitProperties())
                    .callback(this::doFormResult)
                    .doModal();

        }
    }

    private void doFormResult(FormReturnEnum ok, JInvFXFormController dctl) {
     doRefresh();
    }

    private void doRefresh() {
        cus_doc.executeQuery();
    }
}
