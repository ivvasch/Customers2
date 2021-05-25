package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import ru.inversion.customers2.pojo.PCusAddr;
import ru.inversion.customers2.pojo.PCusDocum;
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

public class CUSADDRController extends JInvFXBrowserController {

    @FXML
    private JInvToolBar toolBarAddr;
    @FXML
    private JInvTable<PCusAddr> cus_addr;
    private XXIDataSet<PCusAddr> dsPcusAddr;
    private AllDataSet dataSet;


    protected void init(AllDataSet dataSet) throws Exception {
        this.dataSet = dataSet;
        setTitle("Таблица Cus_ADDR");
        initDataSet();
        DSFXAdapter<PCusAddr> dsfx = DSFXAdapter.bind(dsPcusAddr, cus_addr, null, false);
//        dsfx.setEnableFilter(true);
        initToolBar();
        doRefresh();
        cus_addr.setToolBar(toolBarAddr);
        cus_addr.setAction(ActionFactory.ActionTypeEnum.CREATE, a -> doOperation(FormModeEnum.VM_INS));
        cus_addr.setAction(ActionFactory.ActionTypeEnum.CREATE_BY, a -> doOperation(FormModeEnum.VM_NONE));
        cus_addr.setAction(ActionFactory.ActionTypeEnum.VIEW, a -> doOperation(FormModeEnum.VM_SHOW));
        cus_addr.setAction(ActionFactory.ActionTypeEnum.UPDATE, a -> doOperation(FormModeEnum.VM_EDIT));
        cus_addr.setAction(ActionFactory.ActionTypeEnum.DELETE, a -> doOperation(FormModeEnum.VM_DEL));
        cus_addr.setAction(ActionFactory.ActionTypeEnum.REFRESH, a -> doRefresh());
    }

    private void initDataSet() {
        dataSet.setCusaddrController(this);
        dsPcusAddr = dataSet.getDsPcusAddr();
//        DataLinkBuilder.linkDataSet(dataSet.getDsPcusAddr(), /* внести геттер датасет следующей таблицы */, PCusAddr::getICUSNUM, "ICUSNUM");
    }

    private void initToolBar() {
        toolBarAddr.setStandartActions(ActionFactory.ActionTypeEnum.CREATE,
                ActionFactory.ActionTypeEnum.CREATE_BY,
                ActionFactory.ActionTypeEnum.VIEW,
                ActionFactory.ActionTypeEnum.UPDATE,
                ActionFactory.ActionTypeEnum.DELETE,
                ActionFactory.ActionTypeEnum.REFRESH);
    }

    private void doOperation(FormModeEnum mode) {
        PCusAddr cus_addr = null;
        switch (mode) {
            case VM_INS:
                cus_addr = new PCusAddr();
                break;
            case VM_NONE:
                if (dsPcusAddr.getCurrentRow() == null)
                    break;
                mode = FormModeEnum.VM_INS;
                cus_addr = new PCusAddr();
                for (IEntityProperty<PCusAddr, ?> value : EntityMetadataFactory.getEntityMetaData(PCusAddr.class).getPropertiesMap().values())
                    if (!(value.isTransient() || value.isId()))
                        value.invokeSetter(cus_addr, value.invokeGetter(dsPcusAddr.getCurrentRow()));
                break;
            case VM_EDIT:
            case VM_SHOW:
            case VM_DEL:
                cus_addr = dsPcusAddr.getCurrentRow();
                break;
        }
        if (cus_addr != null) {
            new FXFormLauncher<>(this, EditCusAddrController.class)
                    .dataObject(cus_addr)
                    .dialogMode(mode)
                    .callback(this::doFormResult)
                    .doModal();
        }
    }

    private void doFormResult(FormReturnEnum ok, JInvFXFormController dctl) {
        if (FormReturnEnum.RET_OK == ok) {
            switch (dctl.getFormMode()) {
                case VM_INS:
                    dsPcusAddr.insertRow((PCusAddr) dctl.getDataObject(), IDataSet.InsertRowModeEnum.AFTER_CURRENT, true);
                    break;
                case VM_EDIT:
                    dsPcusAddr.updateCurrentRow((PCusAddr) dctl.getDataObject());
                    break;
                case VM_DEL:
                    dsPcusAddr.removeCurrentRow();
                    break;
                default:
                    break;
            }
        }
        cus_addr.requestFocus();
    }

    private void doRefresh() {
        cus_addr.executeQuery();
    }
}
