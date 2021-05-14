package ru.inversion.customers2;

import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.stage.WindowEvent;
import ru.inversion.annotation.StartMethod;
import ru.inversion.customers2.controller.CustomersController;
import ru.inversion.fx.app.BaseApp;
import ru.inversion.fx.app.es.JInvErrorService;
import ru.inversion.fx.form.FXFormLauncher;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.ViewContext;
import ru.inversion.tc.TaskContext;

public class App extends BaseApp
{
    @Override
    public String getAppID() {
        return "Customers2";
    }
    
    @Override
    public void showMainWindow() {
        showViewEventHandler(getPrimaryViewContext(), null, Collections.EMPTY_MAP);
    }
@StartMethod(description = "CustomersNew")
    private void showViewEventHandler(ViewContext vc, TaskContext tc, Map<String, Object> map) {
    new FXFormLauncher(tc, vc, CustomersController.class)
            .initProperties(map)
            .show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
