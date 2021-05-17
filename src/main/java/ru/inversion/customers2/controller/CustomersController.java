package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import ru.inversion.fx.form.JInvFXBrowserController;

public class CustomersController extends JInvFXBrowserController {
    // окно вкладок
    @FXML private TabPane tabPane;
    // вкладки
    @FXML private Tab tabCus;
    @FXML private Tab tabCusDocum;
    @FXML private Tab tabCussAddr;
    @FXML private Tab tabCusContacts;
    @FXML private Tab tabAllCus;
    // контроллеры вкладок
    @FXML private CUSController cusController;
    @FXML private CUS_ADDRController cus_addrController;
    @FXML private CUS_CONTACTSController cus_contactsController;
    @FXML private CUS_DOCUMController cus_documController;
    @FXML private ALL_CUSController all_cusController;


    @Override
    protected void init() throws Exception {
        super.init();

        cusController.setViewContext(getViewContext());
        cusController.setTaskContext(getTaskContext());
        cusController.setTitle("Таблица CUS");

        cus_addrController.setViewContext(getViewContext());
        cus_addrController.setTaskContext(getTaskContext());
        cus_addrController.setTitle("Адреса клиентов");

        cus_contactsController.setViewContext(getViewContext());
        cus_contactsController.setTaskContext(getTaskContext());
        cus_contactsController.setTitle("Контакты клиента");

        cus_documController.setViewContext(getViewContext());
        cus_documController.setTaskContext(getTaskContext());
        cus_documController.setTitle("Документы клиента");

        all_cusController.setViewContext(getViewContext());
        all_cusController.setTaskContext(getTaskContext());
        all_cusController.setTitle("Общая информация по клиентам");

        cusController.init();
        cus_addrController.init();
        cus_contactsController.init();
        cus_documController.init();
        all_cusController.init();

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }
}
