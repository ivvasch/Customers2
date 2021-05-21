package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import ru.inversion.customers2.pojo.PCus_Addr;
import ru.inversion.customers2.service.ServiceMap;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.JInvFXFormController;
import ru.inversion.fx.form.controls.JInvButton;
import ru.inversion.fx.form.controls.JInvLongField;
import ru.inversion.fx.form.controls.JInvTextField;

public class EditCus_AddrController extends JInvFXBrowserController {

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
    @FXML private JInvButton btnOk;
    @FXML private JInvButton btnCancell;
    private Long ACT;
    private PCus_Addr cusadr;

    @Override
    protected void init() throws Exception {
        super.init();
        cusadr = (PCus_Addr) getDataObject();
        btnOk.setOnAction((event) -> {
            switch (getFormMode()) {
                case VM_INS:
                    setACT(1L);
                    break;
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
        });
        cusadr.setICUSNUM(ICUSNUM.getValue() == null ? 0 : ICUSNUM.getValue());
        cusadr.setADDR_TYPE(Long.valueOf(ADDR_TYPE.getValue().toString().substring(0, 1)));
        cusadr.setCOUNTRY(COUNTRY.getText());
        cusadr.setPOST_INDEX(POST_INDEX.getText());
        cusadr.setCITY(CITY.getText());
        cusadr.setINFR_TYPE(INFR_TYPE.getText());
        cusadr.setINFR_NAME(INFR_NAME.getText());
        cusadr.setDOM(DOM.getText());
        cusadr.setKORP(KORP.getText());
        cusadr.setKV(KV.getText());
        cusadr.setACT(getACT());

        ServiceMap.servMap(cusadr, "ivv_cus_addr_ins", this);
        this.close();

        btnCancell.setOnAction(event -> {
            this.close();
        });
    }


    public Long getACT() {
        return ACT;
    }

    public void setACT(Long ACT) {
        this.ACT = ACT;
    }
}
