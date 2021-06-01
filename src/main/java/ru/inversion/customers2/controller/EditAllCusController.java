package ru.inversion.customers2.controller;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import jfxtras.scene.control.LocalDateTextField;
import ru.inversion.customers2.pojo.PAllCus;
import ru.inversion.customers2.service.ServiceMap;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.controls.JInvButton;
import ru.inversion.fx.form.controls.JInvLongField;
import ru.inversion.fx.form.controls.JInvTextField;

public class EditAllCusController extends JInvFXBrowserController {

    @FXML private JInvLongField ICUSNUM;
    @FXML private ComboBox CCUSFLAG;
    @FXML private JInvTextField CCUSFIRST_NAME;
    @FXML private JInvTextField CCUSMIDDLE_NAME;
    @FXML private JInvTextField CCUSLAST_NAME;
    @FXML private LocalDateTextField DCUSBIRTHDAY;
    @FXML private JInvTextField CCUSNUMNAL;
    @FXML private JInvTextField CCUSSNILS;
    @FXML private JInvLongField ID_PHONE;
    @FXML private JInvLongField PH_NUMNUM;
    @FXML private JInvLongField ID_EMAIL;
    @FXML private JInvTextField E_MAIL;
    @FXML private JInvLongField ID_DOC;
    @FXML private ComboBox ID_DOC_TP;
    @FXML private JInvTextField DOC_SER;
    @FXML private JInvTextField DOC_NUM;
    @FXML private LocalDateTextField DOC_DATE;
    @FXML private JInvTextField DOC_AGENCY;
    @FXML private JInvLongField ID_ADDR;
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
    @FXML private Long ACT;
    private PAllCus allCus;

    @Override
    protected void init() throws Exception {
        super.init();
        allCus = (PAllCus) getDataObject();
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
            COUNTRY.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                    if (COUNTRY.getText().length() > 3) {
                            COUNTRY.deleteText(0,3);

                    }
                }
            });

            // наполнение данными
            allCus.setICUSNUM(ICUSNUM.getValue() == null ? 0 : ICUSNUM.getValue());
            allCus.setCCUSFLAG(CCUSFLAG.getValue().toString().substring(0, 1));
            allCus.setCCUSFIRST_NAME(CCUSFIRST_NAME.getText());
            allCus.setCCUSMIDDLE_NAME(CCUSMIDDLE_NAME.getText());
            allCus.setCCUSLAST_NAME(CCUSLAST_NAME.getText());
            allCus.setDCUSBIRTHDAY(DCUSBIRTHDAY.getLocalDate());
            allCus.setCCUSNUMNAL(CCUSNUMNAL.getText());
            allCus.setCCUSSNILS(CCUSSNILS.getText());
            allCus.setID_PHONE(ID_PHONE.getValue());
            allCus.setPH_NUMNUM(PH_NUMNUM.getValue());
            allCus.setID_EMAIL(ID_EMAIL.getValue());
            allCus.setE_MAIL(E_MAIL.getText());
            allCus.setID_DOC(ID_DOC.getValue());
            allCus.setID_DOC_TP(Long.valueOf(ID_DOC_TP.getValue().toString().substring(0, 2)));
            allCus.setDOC_SER(DOC_SER.getText());
            allCus.setDOC_NUM(DOC_NUM.getText());
            allCus.setDOC_DATE(DOC_DATE.getLocalDate());
            allCus.setDOC_AGENCY(DOC_AGENCY.getText());
            allCus.setID_ADDR(ID_ADDR.getValue());
            allCus.setADDR_TYPE(Long.valueOf(ADDR_TYPE.getValue().toString().substring(0, 1)));
            allCus.setCOUNTRY(COUNTRY.getText());
            allCus.setPOST_INDEX(POST_INDEX.getText());
            allCus.setCITY(CITY.getText());
            allCus.setINFR_TYPE(INFR_TYPE.getText());
            allCus.setINFR_NAME(INFR_NAME.getText());
            allCus.setDOM(DOM.getText());
            allCus.setKORP(KORP.getText());
            allCus.setKV(KV.getText());
            allCus.setACT(getACT());

            if (COUNTRY.getText().length() > 3) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("В поле Страна необходимо ввести не более 3х символов");
                alert.showAndWait();
            } else {
                ServiceMap.servMap(allCus, "ivv_cus_all_ins", this);
                this.close();
            }


        });
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
