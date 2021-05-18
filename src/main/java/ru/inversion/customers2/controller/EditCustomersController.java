package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import jfxtras.scene.control.LocalDateTextField;
import ru.inversion.bicomp.util.ParamMap;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.db.expr.SQLExpressionException;
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
    @FXML private JInvTextField CCUSNUMNAL;
    @FXML private JInvTextField CCUSSNILS;
    @FXML private LocalDateTextField DCUSBIRTHDAY;
    @FXML private JInvButton btOk;
    @FXML private JInvButton btCancell;
    private Long ACT;
    private Stage dialogSatge;
    private PCustomers customers;


    @Override
    protected void init() throws Exception {
        super.init();
        btOk.setOnAction((event) -> {
        if (getFormMode() == FormModeEnum.VM_INS){
            setACT(1L);
        }
//            System.out.println("ccusfirst_name" +  CCUSFIRST_NAME.getText());
//            System.out.println("ccusmiddle_name" + CCUSMIDDLE_NAME.getText());
//            System.out.println("ccuslast_name" + CCUSLAST_NAME.getText());
//            System.out.println("ccusnumnal" + CCUSNUMNAL.getText());
//            System.out.println("ccussnils" + CCUSSNILS.getText());
//            System.out.println("dcusbirthday" + DCUSBIRTHDAY.getLocalDate());
//            System.out.println("act" + getACT());
//            System.out.println(CCUSFLAG.getValue().toString().charAt(0));
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

    public JInvButton getBtOk() {
        return btOk;
    }

    public JInvButton getBtCancell() {
        return btCancell;
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

    public void setBtOk(JInvButton btOk) {
        this.btOk = btOk;
    }

    public void setBtCancell(JInvButton btCancell) {
        this.btCancell = btCancell;
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
}
