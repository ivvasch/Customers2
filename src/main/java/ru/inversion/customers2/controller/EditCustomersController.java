package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import jfxtras.scene.control.LocalDateTextField;
import ru.inversion.bicomp.util.ParamMap;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.db.expr.SQLExpressionException;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.JInvFXFormController;
import ru.inversion.fx.form.controls.JInvButton;
import ru.inversion.fx.form.controls.JInvLongField;
import ru.inversion.fx.form.controls.JInvTextField;

public class EditCustomersController extends JInvFXBrowserController {

    @FXML
    private JInvLongField ICUSNUM;
    @FXML private ComboBox CCUSFLAG;
    @FXML private JInvTextField CCUSFIRST_NAME;
    @FXML private JInvTextField CCUSMIDDLE_NAME;
    @FXML private JInvTextField CCUSLAST_NAME;
    @FXML private JInvTextField CCUSNUMNAL;
    @FXML private JInvTextField CCUSSNILS;
    @FXML private LocalDateTextField DCUSBIRTHDAY;
    @FXML private JInvButton btnOk;
    @FXML private JInvButton btnCancell;
    private Long ACT;
    private Stage dialogSatge;
    private PCustomers customers;


    @Override
    protected void init() throws Exception {
        super.init();
        btnOk.setOnAction((event) -> {
            switch (getFormMode()) {
                case VM_INS:
                case VM_NONE:
                    setACT(1L);
                    break;
                case VM_EDIT:
                    setACT(2L);
                    break;
                case VM_DEL:
                    setACT(3L);
                    break;
            }
            ParamMap map = new ParamMap();
            map.put("ccusflag", CCUSFLAG.getValue().toString().charAt(0));
            map.put("icusnum", ICUSNUM.getValue());
            map.put("ccusfirst_name", CCUSFIRST_NAME.getText());
            map.put("ccusmiddle_name", CCUSMIDDLE_NAME.getText());
            map.put("ccuslast_name", CCUSLAST_NAME.getText());
            map.put("ccusnumnal", CCUSNUMNAL.getText());
            map.put("ccussnils", CCUSSNILS.getText());
            map.put("dcusbirthday", DCUSBIRTHDAY.getLocalDate());
            map.put("act", getACT());
            try {
                map.exec(this, getClass().getResource("plsql/def.xml"), "ivv_cus_ins");
            } catch (SQLExpressionException e) {
                e.printStackTrace();
            }
            this.close(FormReturnEnum.RET_OK);
        });
        btnCancell.setOnAction(event -> {
            this.close(FormReturnEnum.RET_CANCEL);
        });
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

    public JInvTextField getCCUSNUMNAL() {
        return CCUSNUMNAL;
    }

    public JInvTextField getCCUSSNILS() {
        return CCUSSNILS;
    }

    public LocalDateTextField getDCUSBIRTHDAY() {
        return DCUSBIRTHDAY;
    }

    public JInvButton getBtnOk() {
        return btnOk;
    }

    public JInvButton getBtnCancell() {
        return btnCancell;
    }

    public Long getACT() {
        return ACT;
    }

    public Stage getDialogSatge() {
        return dialogSatge;
    }

    public PCustomers getCustomers() {
        return customers;
    }

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

    public void setBtnOk(JInvButton btnOk) {
        this.btnOk = btnOk;
    }

    public void setBtnCancell(JInvButton btnCancell) {
        this.btnCancell = btnCancell;
    }

    public void setACT(Long ACT) {
        this.ACT = ACT;
    }

    public void setDialogSatge(Stage dialogSatge) {
        this.dialogSatge = dialogSatge;
    }

    public void setCustomers(PCustomers customers) {
        this.customers = customers;
    }
    public PCustomers getDataObject() {
        return customers;
    }
}
