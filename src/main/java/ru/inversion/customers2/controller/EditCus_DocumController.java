package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import jfxtras.scene.control.LocalDateTextField;
import ru.inversion.customers2.pojo.PCus_Docum;
import ru.inversion.customers2.service.ServiceMap;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.controls.JInvButton;
import ru.inversion.fx.form.controls.JInvLongField;
import ru.inversion.fx.form.controls.JInvTextField;


public class EditCus_DocumController extends JInvFXBrowserController {

    @FXML private JInvLongField ICUSNUM;
    @FXML private ComboBox ID_DOC_TP;
    @FXML private JInvTextField DOC_SER;
    @FXML private JInvTextField DOC_NUM;
    @FXML private LocalDateTextField DOC_DATE;
    @FXML private JInvTextField DOC_AGENCY;
    @FXML private JInvButton btnOk;
    @FXML private JInvButton btnCancell;
    private  Long ID_DOC;
    private  Long ACT;
    private PCus_Docum cusdoc;

    @Override
    protected void init() throws Exception {
        super.init();
        cusdoc = (PCus_Docum) getDataObject();
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
            cusdoc.setICUSNUM(ICUSNUM.getValue() == null ? 0 : ICUSNUM.getValue());
            cusdoc.setID_DOC_TP(Long.valueOf(ID_DOC_TP.getValue().toString().substring(0, 1)));
            cusdoc.setDOC_SER(DOC_SER.getText());
            cusdoc.setDOC_NUM(DOC_NUM.getText());
            cusdoc.setDOC_DATE(DOC_DATE.getLocalDate());
            cusdoc.setDOC_AGENCY(DOC_AGENCY.getText());
            cusdoc.setACT(getACT());

            ServiceMap.servMap(cusdoc, "ivv_cus_doc_ins", this);

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
