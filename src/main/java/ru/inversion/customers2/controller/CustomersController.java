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
    @FXML private CUSController cusTabPageController;
    @FXML private CUSADDRController cusAddrTabPageController;
    @FXML private CUSCONTACTSController cusContactsTabPageController;
    @FXML private CUSDOCUMController cusDocumTabPageController;
    //    @FXML private ALL_CUSController all_cusController;
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
//        all_cusController.setViewContext(getViewContext());
//        all_cusController.setTaskContext(getTaskContext());
//        all_cusController.setTitle("Общая информация по клиентам");
        /**
         * порядок инициализации сверху вниз
         * идет от последнего Tab в форме к первому,
         * чтобы все датасеты подгрузились перед основной таблицей!
         */
        cusContactsTabPageController.init(dataSet);
        cusAddrTabPageController.init(dataSet);
        cusDocumTabPageController.init(dataSet);
        cusTabPageController.init(dataSet);
//        all_cusController.init();

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }
}
