package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import jfxtras.scene.control.LocalDateTextField;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.customers2.service.ServiceMap;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.controls.JInvButton;
import ru.inversion.fx.form.controls.JInvLongField;
import ru.inversion.fx.form.controls.JInvTextField;

public class EditCustomersController extends JInvFXBrowserController {

    @FXML private JInvLongField ICUSNUM;
    @FXML private ComboBox CCUSFLAG;
    @FXML private JInvTextField CCUSFIRST_NAME;
    @FXML private JInvTextField CCUSMIDDLE_NAME;
    @FXML private JInvTextField CCUSLAST_NAME;
    @FXML private JInvTextField CCUSNUMNAL;
    @FXML private JInvTextField CCUSSNILS;
    @FXML private LocalDateTextField DCUSBIRTHDAY;
    @FXML private JInvButton btnOk;
    @FXML private JInvButton btnCancell;
    @FXML private Long ACT;
    private PCustomers custom;

    @Override
    protected void init() throws Exception {
        super.init();
        custom = (PCustomers) getDataObject();
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
            // наполнение данными
            custom.setICUSNUM(ICUSNUM.getValue() == null ? 0 : ICUSNUM.getValue());
            custom.setCCUSFLAG(CCUSFLAG.getValue().toString().substring(0, 1));
            custom.setCCUSFIRST_NAME(CCUSFIRST_NAME.getText());
            custom.setCCUSMIDDLE_NAME(CCUSMIDDLE_NAME.getText());
            custom.setCCUSLAST_NAME(CCUSLAST_NAME.getText());
            custom.setCCUSNUMNAL(CCUSNUMNAL.getText());
            custom.setCCUSSNILS(CCUSSNILS.getText());
            custom.setDCUSBIRTHDAY(DCUSBIRTHDAY.getLocalDate());
            custom.setACT(getACT());
            // проверочное выведение данных

//            System.out.println("=============> " + custom.getCCUSFIRST_NAME());
//            System.out.println("=============> " + custom.getCCUSMIDDLE_NAME());
//            System.out.println("=============> " + custom.getCCUSLAST_NAME());
//            System.out.println("=============> " + custom.getCCUSSNILS());
//            System.out.println("=============> " + custom.getCCUSNUMNAL());
//            System.out.println("=============> " + custom.getCCUSFLAG());
//            System.out.println("=============> " + custom.getDCUSBIRTHDAY());
//            System.out.println("=============> " + custom.getACT());

            ServiceMap.servMap(custom, "ivv_cus_ins", this);

            this.close();

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
