package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import ru.inversion.fx.form.JInvFXBrowserController;

public class CustomersController extends JInvFXBrowserController {
    // окно вкладок
    @FXML private TabPane tabPane;
    // вкладки
    @FXML private Tab cusTab;
    @FXML private Tab cusDocumTab;
    @FXML private Tab cussAddrTab;
    @FXML private Tab cusContactsTab;
    @FXML private Tab allCusTab;
    // контроллеры вкладок
    @FXML private CUSController cusTabPageController;
    @FXML private CUS_ADDRController cusAddrTabPageController;
//    @FXML private CUS_CONTACTSController cus_contactsController;
    @FXML private CUS_DOCUMController cusDocumTabPageController;
//    @FXML private ALL_CUSController all_cusController;


    @Override
    protected void init() throws Exception {
        super.init();

        cusTabPageController.setViewContext(getViewContext());
        cusTabPageController.setTaskContext(getTaskContext());
        cusTabPageController.setTitle("Таблица CUS");

        cusAddrTabPageController.setViewContext(getViewContext());
        cusAddrTabPageController.setTaskContext(getTaskContext());
        cusAddrTabPageController.setTitle("Адреса клиентов");

//        cus_contactsController.setViewContext(getViewContext());
//        cus_contactsController.setTaskContext(getTaskContext());
//        cus_contactsController.setTitle("Контакты клиента");
//
        cusDocumTabPageController.setViewContext(getViewContext());
        cusDocumTabPageController.setTaskContext(getTaskContext());
        cusDocumTabPageController.setTitle("Документы клиента");
//
//        all_cusController.setViewContext(getViewContext());
//        all_cusController.setTaskContext(getTaskContext());
//        all_cusController.setTitle("Общая информация по клиентам");

        cusTabPageController.init();
        cusAddrTabPageController.init();
//        cus_contactsController.init();
        cusDocumTabPageController.init();
//        all_cusController.init();

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }
}
