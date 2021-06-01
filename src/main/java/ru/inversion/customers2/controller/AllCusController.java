package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import ru.inversion.customers2.pojo.PAllCus;
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

public class AllCusController extends JInvFXBrowserController {

    @FXML private JInvToolBar toolBar;
    @FXML private JInvTable<PAllCus> allcus;
    private XXIDataSet<PAllCus> dsPAllCus = new XXIDataSet<>();
    AllDataSet dataSet;


    protected void init(AllDataSet dataSet) throws Exception {
        this.dataSet = dataSet;
        setTitle("Таблица AllCus");
        initDataSet();
        DSFXAdapter<PAllCus> dsfx = DSFXAdapter.bind(dsPAllCus, allcus, null, false);
//        dsfx.setEnableFilter(true);
        initToolBar();
        doRefresh();
        allcus.setToolBar(toolBar);
        allcus.setAction(ActionFactory.ActionTypeEnum.CREATE, a -> doOperation(FormModeEnum.VM_INS));
        allcus.setAction(ActionFactory.ActionTypeEnum.CREATE_BY, a -> doOperation(FormModeEnum.VM_NONE));
        allcus.setAction(ActionFactory.ActionTypeEnum.VIEW, a -> doOperation(FormModeEnum.VM_SHOW));
        allcus.setAction(ActionFactory.ActionTypeEnum.UPDATE, a -> doOperation(FormModeEnum.VM_EDIT));
        allcus.setAction(ActionFactory.ActionTypeEnum.DELETE, a -> doOperation(FormModeEnum.VM_DEL));
        allcus.setAction(ActionFactory.ActionTypeEnum.REFRESH, a -> doRefresh());
    }

    private void initDataSet() {
        dataSet.setAllCusController(this);
        dsPAllCus = dataSet.getDsAllCus();

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
        PAllCus customers = null;
        switch (mode) {
            case VM_INS:
                customers = new PAllCus();
                customers.setICUSNUM(dsPAllCus.getCurrentRow().getICUSNUM());

                break;
            case VM_NONE:
                if (dsPAllCus.getCurrentRow() == null)
                    break;
                    mode = FormModeEnum.VM_INS;
                    customers = new PAllCus();
                    for (IEntityProperty<PAllCus, ?> value : EntityMetadataFactory.getEntityMetaData(PAllCus.class)
                            .getPropertiesMap().values()) {
                        if (!(value.isTransient() || value.isId()))
                            value.invokeSetter(customers, value.invokeGetter(dsPAllCus.getCurrentRow()));
                        break;
                    }
            case VM_EDIT:
            case VM_SHOW:
            case VM_DEL:
                customers = dsPAllCus.getCurrentRow();
                break;
        }
        if (customers != null) {
            new FXFormLauncher<>(this, EditAllCusController.class)
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
        allcus.executeQuery();
    }
}
