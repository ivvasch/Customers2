package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import ru.inversion.customers2.pojo.PCus_Addr;
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

public class CUS_ADDRController extends JInvFXBrowserController {

    @FXML
    private JInvToolBar toolBarAddr;
    @FXML
    private JInvTable<PCus_Addr> cus_addr;
    private XXIDataSet<PCus_Addr> dsPcusAddr = new XXIDataSet<>();


    @Override
    protected void init() throws Exception {
        setTitle("Таблица Cus_ADDR");
        initDataSet();
        DSFXAdapter<PCus_Addr> dsfx = DSFXAdapter.bind(dsPcusAddr, cus_addr, null, false);
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

//        for (TableColumn allColumn : cus_addr.getAllColumns()) {
//            if (allColumn.getText().equals("Тип адреса")) {
//                allColumn.setSortable(false);
//            }
//            System.out.println("=====>" + allColumn.getText());
//        }
    }

    private void initDataSet() {
        dsPcusAddr.setTaskContext(getTaskContext());
        dsPcusAddr.setRowClass(PCus_Addr.class);
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
        PCus_Addr cus_addr = null;
        switch (mode) {
            case VM_INS:
                cus_addr = new PCus_Addr();
                break;
            case VM_NONE:
                if (dsPcusAddr.getCurrentRow() == null)
                    break;
                mode = FormModeEnum.VM_INS;
                cus_addr = new PCus_Addr();
                for (IEntityProperty<PCus_Addr, ?> value : EntityMetadataFactory.getEntityMetaData(PCus_Addr.class).getPropertiesMap().values())
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
            new FXFormLauncher<>(this, EditCus_AddrController.class)
                    .dataObject(cus_addr)
                    .dialogMode(mode)
                    .callback(this::doFormResult)
                    .doModal();
        }
    }

    private void doFormResult(FormReturnEnum ok, JInvFXFormController<PCus_Addr> dctl) {
        if (FormReturnEnum.RET_OK == ok) {
            switch (dctl.getFormMode()) {
                case VM_INS:
                    dsPcusAddr.insertRow(dctl.getDataObject(), IDataSet.InsertRowModeEnum.AFTER_CURRENT, true);
                    break;
                case VM_EDIT:
                    dsPcusAddr.updateCurrentRow(dctl.getDataObject());
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
