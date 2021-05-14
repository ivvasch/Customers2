package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.dataset.XXIDataSet;
import ru.inversion.dataset.fx.DSFXAdapter;
import ru.inversion.fx.form.ActionFactory;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.controls.JInvTable;
import ru.inversion.fx.form.controls.JInvToolBar;

public class CustomersController extends JInvFXBrowserController {

    @FXML private JInvToolBar toolBar;
    @FXML private JInvTable<PCustomers> customers;
    private XXIDataSet<PCustomers> dsPcus = new XXIDataSet<>();


    @Override
    protected void init() throws Exception {
        setTitle("Таблица Customers");
        initDataSet();
        DSFXAdapter<PCustomers> dsfx = DSFXAdapter.bind(dsPcus, customers, null, false);
//        dsfx.setEnableFilter(true);
        initToolBar();
        customers.setAction(ActionFactory.ActionTypeEnum.CREATE, a -> doOperation("ins"));
        customers.setAction(ActionFactory.ActionTypeEnum.CREATE_BY, a -> doOperation("dbl"));
        customers.setAction(ActionFactory.ActionTypeEnum.VIEW, a -> doOperation("view"));
        customers.setAction(ActionFactory.ActionTypeEnum.UPDATE, a -> doOperation("upd"));
        customers.setAction(ActionFactory.ActionTypeEnum.DELETE, a -> doOperation("del"));
        customers.setAction(ActionFactory.ActionTypeEnum.REFRESH, a -> doRefresh());
    }

    private void initDataSet() {
        dsPcus.setTaskContext(getTaskContext());
        dsPcus.setRowClass(PCustomers.class);
    }

    private void initToolBar() {
        toolBar.setStandartActions(ActionFactory.ActionTypeEnum.CREATE,
                ActionFactory.ActionTypeEnum.CREATE_BY,
                ActionFactory.ActionTypeEnum.VIEW,
                ActionFactory.ActionTypeEnum.UPDATE,
                ActionFactory.ActionTypeEnum.DELETE,
                ActionFactory.ActionTypeEnum.REFRESH);
    }

    private void doOperation(String mode) {

    }

    private void doRefresh() {
        customers.executeQuery();
    }
}
