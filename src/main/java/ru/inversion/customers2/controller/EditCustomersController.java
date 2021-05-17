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

public class EditCustomersController extends JInvFXFormController<PCustomers> {

    @FXML private JInvLongField ICUSNUM;
    @FXML private ComboBox CCUSFLAG;
    @FXML private JInvTextField CCUSFIRST_NAME;
    @FXML private JInvTextField CCUSMIDDLE_NAME;
    @FXML private JInvTextField CCUSLAST_NAME;
    @FXML private JInvLongField CCUSNUMNAL;
    @FXML private JInvTextField CCUSSNILS;
    @FXML private LocalDateTextField DCUSBIRTHDAY;
    private Stage dialogSatge;
    private PCustomers customers;


    public void setCustomers(PCustomers customers) {
        this.customers = customers;

        ICUSNUM.setText(customers.getICUSNUM().toString());
//        CCUSFLAG.setButtonCell(customers.getCCUSFLAG());
        CCUSFIRST_NAME.setText(customers.getCCUSFIRST_NAME());
        CCUSMIDDLE_NAME.setText(customers.getCCUSMIDDLE_NAME());
        CCUSLAST_NAME.setText(customers.getCCUSLAST_NAME());
        CCUSNUMNAL.setText(customers.getCCUSNUMNAL().toString());
        CCUSSNILS.setText(customers.getCCUSSNILS());
        DCUSBIRTHDAY.setText(customers.getDCUSBIRTHDAY().toString());
    }

    public JInvLongField getICUSNUM() {
        return ICUSNUM;
    }

    public ComboBox getCCUSFLAG() {
        return CCUSFLAG;
    }

    public JInvTextField getCCUSFIRST_NAME() {
        return CCUSFIRST_NAME;
    }

    public JInvTextField getCCUSMIDDLE_NAME() {
        return CCUSMIDDLE_NAME;
    }

    public JInvTextField getCCUSLAST_NAME() {
        return CCUSLAST_NAME;
    }

    public JInvLongField getCCUSNUMNAL() {
        return CCUSNUMNAL;
    }

    public JInvTextField getCCUSSNILS() {
        return CCUSSNILS;
    }

    public LocalDateTextField getDCUSBIRTHDAY() {
        return DCUSBIRTHDAY;
    }
    // ============= Сеттеры


    public void setICUSNUM(JInvLongField ICUSNUM) {
        this.ICUSNUM = ICUSNUM;
    }

    public void setCCUSFLAG(ComboBox CCUSFLAG) {
        this.CCUSFLAG = CCUSFLAG;
    }

    public void setCCUSFIRST_NAME(JInvTextField CCUSFIRST_NAME) {
        this.CCUSFIRST_NAME = CCUSFIRST_NAME;
    }

    public void setCCUSMIDDLE_NAME(JInvTextField CCUSMIDDLE_NAME) {
        this.CCUSMIDDLE_NAME = CCUSMIDDLE_NAME;
    }

    public void setCCUSLAST_NAME(JInvTextField CCUSLAST_NAME) {
        this.CCUSLAST_NAME = CCUSLAST_NAME;
    }

    public void setCCUSNUMNAL(JInvLongField CCUSNUMNAL) {
        this.CCUSNUMNAL = CCUSNUMNAL;
    }

    public void setCCUSSNILS(JInvTextField CCUSSNILS) {
        this.CCUSSNILS = CCUSSNILS;
    }

    public void setDCUSBIRTHDAY(LocalDateTextField DCUSBIRTHDAY) {
        this.DCUSBIRTHDAY = DCUSBIRTHDAY;
    }


    public void setDialogStage(Stage stage) {
        this.dialogSatge = stage;
    }

}
