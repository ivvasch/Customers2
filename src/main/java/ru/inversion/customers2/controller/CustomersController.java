package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import ru.inversion.customers2.service.AllDataSet;
import ru.inversion.fx.form.JInvFXBrowserController;

public class CustomersController extends JInvFXBrowserController {
    // окно вкладок
    @FXML private TabPane tabPane;
    // вкладки
    @FXML private Tab cusTab;
    @FXML private Tab cusDocumTab;
    @FXML private Tab cusAddrTab;
    @FXML private Tab cusContactsTab;
    @FXML private Tab allCusTab;
    // контроллеры вкладок
    @FXML private CusController cusTabPageController;
    @FXML private CusAddrController cusAddrTabPageController;
    @FXML private CusContactsController cusContactsTabPageController;
    @FXML private CusDocumController cusDocumTabPageController;
    @FXML private AllCusController allCusTabPageController;
    private AllDataSet dataSet = new AllDataSet();


    @Override
    protected void init() throws Exception {
        super.init();
        cusTabPageController.setViewContext(getViewContext());
        cusTabPageController.setTaskContext(getTaskContext());
        cusTabPageController.setTitle("Таблица CUS");

        cusAddrTabPageController.setViewContext(getViewContext());
        cusAddrTabPageController.setTaskContext(getTaskContext());
        cusAddrTabPageController.setTitle("Адреса клиентов");

        cusContactsTabPageController.setViewContext(getViewContext());
        cusContactsTabPageController.setTaskContext(getTaskContext());
        cusContactsTabPageController.setTitle("Контакты клиента");
//
        cusDocumTabPageController.setViewContext(getViewContext());
        cusDocumTabPageController.setTaskContext(getTaskContext());
        cusDocumTabPageController.setTitle("Документы клиента");
//
        allCusTabPageController.setViewContext(getViewContext());
        allCusTabPageController.setTaskContext(getTaskContext());
        allCusTabPageController.setTitle("Общая информация по клиентам");
        /**
         * порядок инициализации сверху вниз
         * идет от последнего Tab в форме к первому,
         * чтобы все датасеты подгрузились перед основной таблицей!
         */
        allCusTabPageController.init(dataSet);
        cusContactsTabPageController.init(dataSet);
        cusAddrTabPageController.init(dataSet);
        cusDocumTabPageController.init(dataSet);
        cusTabPageController.init(dataSet);

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }
}
