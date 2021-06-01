package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import ru.inversion.customers2.pojo.PCusContacts;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.customers2.service.AllDataSet;
import ru.inversion.customers2.service.ServiceMap;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.controls.JInvButton;
import ru.inversion.fx.form.controls.JInvLongField;
import ru.inversion.fx.form.controls.JInvTextField;

public class EditCusContactsController extends JInvFXBrowserController {

    @FXML private JInvLongField ICUSNUM;
    @FXML private JInvLongField ID_EMAIL;
    @FXML private JInvLongField ID_PHONE;
    @FXML private JInvTextField COUNTRY;
    @FXML private JInvTextField E_MAIL;
    @FXML private JInvLongField PH_NUMNUM;
    @FXML private JInvButton btnOk;
    @FXML private JInvButton btnCancell;
    private Long ACT;
    private PCusContacts pCusContacts;
    private PCustomers pCustomers;
    private AllDataSet dataSet;

    @Override
    protected void init() throws Exception {
        super.init();
        pCusContacts = (PCusContacts) getDataObject();
        btnOk.setOnAction(event -> {
            switch (getFormMode()) {
                case VM_INS:
                    setACT(2L);
                    break;
                case VM_NONE:
                    setACT(2L);
                    break;
                case VM_EDIT:
                    setACT(2L);
                    break;
                case VM_DEL:
                    setACT(3L);
                    break;
            }
//            pCusContacts.setICUSNUM(ICUSNUM.getValue() == null ?pCusContacts.getICUSNUM():ICUSNUM.getValue());
            pCusContacts.setID_EMAIL(ID_EMAIL.getValue());
            pCusContacts.setID_PHONE(ID_PHONE.getValue());
            pCusContacts.setCOUNTRY(COUNTRY.getText());
            pCusContacts.setE_MAIL(E_MAIL.getText());
            pCusContacts.setPH_NUMNUM(Long.valueOf(PH_NUMNUM.getText()));
            pCusContacts.setACT(getACT());

            ServiceMap.servMap(pCusContacts, "ivv_cus_contacts_ins", this);
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
