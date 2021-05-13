package ru.inversion.customers2.controller;

import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.dataset.XXIDataSet;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.controls.JInvTable;
import ru.inversion.fx.form.controls.JInvToolBar;

public class CustomersController extends JInvFXBrowserController {

    private JInvToolBar toolBar;
    private JInvTable<PCustomers> customers;
    private XXIDataSet<PCustomers> dsPcus = new XXIDataSet<PCustomers>();


    @Override
    protected void init() throws Exception {


    }
}
