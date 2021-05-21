package ru.inversion.customers2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import ru.inversion.customers2.pojo.PCus_Docum;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.JInvFXFormController;
import ru.inversion.fx.form.controls.JInvButton;

import java.time.LocalDate;

public class EditCus_DocumController extends JInvFXBrowserController {

    @FXML private Long ICUSNUM;
    @FXML private ComboBox ID_DOC_TP;
    @FXML private  String DOC_SER;
    @FXML private  String DOC_NUM;
    @FXML private LocalDate DOC_DATE;
    @FXML private  String DOC_AGENCY;
    private JInvButton btnOk;
    private JInvButton btnCancell;
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
        });

        cusdoc.setACT(getACT());

    }

    public Long getACT() {
        return ACT;
    }

    public void setACT(Long ACT) {
        this.ACT = ACT;
    }
}
