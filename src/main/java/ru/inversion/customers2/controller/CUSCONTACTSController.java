package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import ru.inversion.customers2.pojo.PCusContacts;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.customers2.service.AllDataSet;
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

public class CUSCONTACTSController extends JInvFXBrowserController {

    @FXML private JInvToolBar toolBar;
    @FXML private JInvTable<PCusContacts> cuscontacts;
    private XXIDataSet<PCusContacts> dsPcusContacts;
    AllDataSet dataSet;


    protected void init(AllDataSet dataSet) throws Exception {
        this.dataSet = dataSet;
        setTitle("Таблица Customers");
        initDataSet();
        DSFXAdapter<PCusContacts> dsfx = DSFXAdapter.bind(dsPcusContacts, cuscontacts, null, false);
//        dsfx.setEnableFilter(true);
        initToolBar();
        doRefresh();
        cuscontacts.setToolBar(toolBar);
        cuscontacts.setAction(ActionFactory.ActionTypeEnum.CREATE, a -> doOperation(FormModeEnum.VM_INS));
        cuscontacts.setAction(ActionFactory.ActionTypeEnum.CREATE_BY, a -> doOperation(FormModeEnum.VM_NONE));
        cuscontacts.setAction(ActionFactory.ActionTypeEnum.VIEW, a -> doOperation(FormModeEnum.VM_SHOW));
        cuscontacts.setAction(ActionFactory.ActionTypeEnum.UPDATE, a -> doOperation(FormModeEnum.VM_EDIT));
        cuscontacts.setAction(ActionFactory.ActionTypeEnum.DELETE, a -> doOperation(FormModeEnum.VM_DEL));
        cuscontacts.setAction(ActionFactory.ActionTypeEnum.REFRESH, a -> doRefresh());
    }

    private void initDataSet() {
        dataSet.setCuscontactsController(this);
        dsPcusContacts = dataSet.getDsPcusContacts();
    }

    private void initToolBar() {
        toolBar.setStandartActions(ActionFactory.ActionTypeEnum.CREATE,
                ActionFactory.ActionTypeEnum.CREATE_BY,
                ActionFactory.ActionTypeEnum.VIEW,
                ActionFactory.ActionTypeEnum.UPDATE,
                ActionFactory.ActionTypeEnum.DELETE,
                ActionFactory.ActionTypeEnum.REFRESH);
    }

    private void doOperation(FormModeEnum mode) {
        PCusContacts customers = null;
        switch (mode) {
            case VM_INS:
                customers = new PCusContacts();
                break;
            case VM_NONE:
                if (dsPcusContacts.getCurrentRow() == null)
                    break;
                    mode = FormModeEnum.VM_INS;
                    customers = new PCusContacts();
                    for (IEntityProperty<PCusContacts, ?> value : EntityMetadataFactory.getEntityMetaData(PCusContacts.class)
                            .getPropertiesMap().values()) {
                        if (!(value.isTransient() || value.isId()))
                            value.invokeSetter(customers, value.invokeGetter(dsPcusContacts.getCurrentRow()));
                        break;
                    }
            case VM_EDIT:
            case VM_SHOW:
            case VM_DEL:
                customers = dsPcusContacts.getCurrentRow();
                break;
        }
        if (customers != null) {
            new FXFormLauncher<>(this, EditCusContactsController.class)
                    .dataObject(customers)
                    .dialogMode(mode)
                    .initProperties(getInitProperties())
//                    .callback(this::doFormResult)
                    .doModal();

        }
    }

    private void doFormResult(FormReturnEnum ok, JInvFXFormController<PCusContacts> dctl) {
        if (FormReturnEnum.RET_OK == ok) {
            switch (dctl.getFormMode()) {
                case VM_INS:
                    dsPcusContacts.insertRow(dctl.getDataObject(), IDataSet.InsertRowModeEnum.AFTER_CURRENT, true);
                    break;
                case VM_EDIT:
                    dsPcusContacts.updateCurrentRow(dctl.getDataObject());
                    break;
                case VM_DEL:
                    dsPcusContacts.removeCurrentRow();
                    break;
                default:
                    break;
            }
        }
        cuscontacts.requestFocus();
    }

    private void doRefresh() {
        cuscontacts.executeQuery();
    }
}
