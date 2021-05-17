package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import jfxtras.scene.control.LocalDateTextField;
import ru.inversion.customers2.pojo.PCus_Addr;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.fx.form.JInvFXFormController;
import ru.inversion.fx.form.controls.JInvLongField;
import ru.inversion.fx.form.controls.JInvTextField;

public class EditCus_AddrController extends JInvFXFormController<PCus_Addr> {

    @FXML private JInvLongField ICUSNUM;
    @FXML private ComboBox ADDR_TYPE;
    @FXML private JInvTextField COUNTRY;
    @FXML private JInvTextField POST_INDEX;
    @FXML private JInvTextField CITY;
    @FXML private JInvTextField INFR_TYPE;
    @FXML private JInvTextField INFR_NAME;
    @FXML private JInvTextField DOM;
    @FXML private JInvTextField KORP;
    @FXML private JInvTextField KV;
    private Stage dialogSatge;
    private PCus_Addr cus_addr;


    public void setCustomers(PCus_Addr cus_addr) {
        this.cus_addr = cus_addr;

    }



    public void setDialogStage(Stage stage) {
        this.dialogSatge = stage;
    }

}
