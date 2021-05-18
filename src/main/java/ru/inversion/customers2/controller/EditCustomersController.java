package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import jfxtras.scene.control.LocalDateTextField;
import ru.inversion.bicomp.util.ParamMap;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.fx.form.JInvFXFormController;
import ru.inversion.fx.form.controls.JInvButton;
import ru.inversion.fx.form.controls.JInvLongField;
import ru.inversion.fx.form.controls.JInvTextField;

public class EditCustomersController extends JInvFXFormController<PCustomers> {

    @FXML
    private JInvLongField ICUSNUM;
    @FXML private ComboBox CCUSFLAG;
    @FXML private JInvTextField CCUSFIRST_NAME;
    @FXML private JInvTextField CCUSMIDDLE_NAME;
    @FXML private JInvTextField CCUSLAST_NAME;
    @FXML private JInvLongField CCUSNUMNAL;
    @FXML private JInvTextField CCUSSNILS;
    @FXML private LocalDateTextField DCUSBIRTHDAY;
    @FXML private JInvButton btOk;
    @FXML private JInvButton btCancell;
    private Stage dialogSatge;
    private PCustomers customers;


    @Override
    protected void init() throws Exception {
        super.init();

        btOk.setOnAction((event) -> {
            ParamMap map = new ParamMap();

        });
    }
}
