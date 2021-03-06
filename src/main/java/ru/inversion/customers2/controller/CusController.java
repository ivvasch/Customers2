package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
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

public class CusController extends JInvFXBrowserController {

    @FXML private JInvToolBar toolBar;
    @FXML private JInvTable<PCustomers> customers;
    private XXIDataSet<PCustomers> dsPcus;
    private AllDataSet dataSet;


    protected void init(AllDataSet dataSet) throws Exception {
        this.dataSet = dataSet;
        initDataSet();
        setTitle("Таблица Customers");
        DSFXAdapter<PCustomers> dsfx = DSFXAdapter.bind(dsPcus, customers, null, false);
//        dsfx.setEnableFilter(true);
        initToolBar();
        doRefresh();
        customers.setToolBar(toolBar);
        customers.setAction(ActionFactory.ActionTypeEnum.CREATE, a -> doOperation(FormModeEnum.VM_INS));
        customers.setAction(ActionFactory.ActionTypeEnum.CREATE_BY, a -> doOperation(FormModeEnum.VM_NONE));
        customers.setAction(ActionFactory.ActionTypeEnum.VIEW, a -> doOperation(FormModeEnum.VM_SHOW));
        customers.setAction(ActionFactory.ActionTypeEnum.UPDATE, a -> doOperation(FormModeEnum.VM_EDIT));
        customers.setAction(ActionFactory.ActionTypeEnum.DELETE, a -> doOperation(FormModeEnum.VM_DEL));
        customers.setAction(ActionFactory.ActionTypeEnum.REFRESH, a -> doRefresh());
    }

    private void initDataSet() {
        dataSet.setCusController(this);
        dsPcus = dataSet.getDsPcus();
        DataLinkBuilder.linkDataSet(dataSet.getDsPcus(), dataSet.getDsPcusDoc(), PCustomers::getICUSNUM, "ICUSNUM");
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
        PCustomers pCustomers = null;
        switch (mode) {
            case VM_INS:
                pCustomers = new PCustomers();
                break;
            case VM_NONE:
                if (dsPcus.getCurrentRow() == null)
                    break;
                    mode = FormModeEnum.VM_INS;
                    pCustomers = new PCustomers();
                    for (IEntityProperty<PCustomers, ?> value : EntityMetadataFactory.getEntityMetaData(PCustomers.class)
                            .getPropertiesMap().values()) {
                        if (!(value.isTransient() || value.isId()))
                            value.invokeSetter(pCustomers, value.invokeGetter(dsPcus.getCurrentRow()));
                        break;
                    }
            case VM_EDIT:
            case VM_SHOW:
            case VM_DEL:
                pCustomers = dsPcus.getCurrentRow();
                break;
        }
        if (pCustomers != null) {
            new FXFormLauncher<>(this, EditCustomersController.class)
                    .dataObject(pCustomers)
                    .dialogMode(mode)
                    .initProperties(getInitProperties())
                    .clb((t, u) -> {
                        switch(t) {
                            case RET_OK:
                                doFormResult(t, u);
                                break;
                            case RET_CANCEL:
                                break;
                        }
                    })
                    .doModal();
        }
    }

    private void doFormResult(FormReturnEnum ok, JInvFXFormController<PCustomers> dctl) {
        if (JInvFXFormController.FormReturnEnum.RET_OK == ok) {
            switch (dctl.getFormMode()) {
                case VM_INS:
                    dsPcus.insertRow((PCustomers) dctl.getDataObject(), IDataSet.InsertRowModeEnum.AFTER_CURRENT, true);
                    break;
                case VM_EDIT:
                    dsPcus.updateCurrentRow((PCustomers) dctl.getDataObject());
                    break;
                case VM_DEL:
                    dsPcus.removeCurrentRow();
                    break;
                default:
                    break;
            }
        }
        customers.requestFocus();
    }

    private void doRefresh() {
        customers.executeQuery();
    }
}
