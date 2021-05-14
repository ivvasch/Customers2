package ru.inversion.customers2.pojo;

import javafx.fxml.FXML;
import ru.inversion.dataset.mark.IDMarkable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "ru.inversion.customers2.PCustomers")
@Table(name = "customers")
@NamedNativeQuery(name = "ru.inversion.customers2.PCustomers", query = "SELECT icusnum, ccusflag, ccusfirst_name, " +
        "ccusmiddle_name, ccuslast_name, ccusnumnal, ccussnils, dcusbirthday FROM cus")
public class PCustomers extends IDMarkable implements Serializable {

    private static final Long serialVersionUID = 13_05_2021_15_12L;

    @FXML
    private Long ICUSNUM;
    @FXML
    private String CCUSFLAG;
    @FXML
    private String CCUSFIRST_NAME;
    @FXML
    private String CCUSMIDDLE_NAME;
    @FXML
    private String CCUSLAST_NAME;
    @FXML
    private Long CCUSNUMNAL;
    @FXML
    private String CCUSSNILS;
    @FXML
    private LocalDate DCUSBIRTHDA;

    @Id
    @Column(name = "ICUSNUM")
    public Long getICUSNUM() {
        return ICUSNUM;
    }

    @Column(name = "CCUSFLAG")
    public String getCCUSFLAG() {
        return CCUSFLAG;
    }

    @Column(name = "CCUSFIRST_NAME")
    public String getCCUSFIRST_NAME() {
        return CCUSFIRST_NAME;
    }

    @Column(name = "CCUSMIDDLE_NAME")
    public String getCCUSMIDDLE_NAME() {
        return CCUSMIDDLE_NAME;
    }

    @Column(name = "CCUSLAST_NAME")
    public String getCCUSLAST_NAME() {
        return CCUSLAST_NAME;
    }

    @Column(name = "CCUSNUMNAL")
    public Long getCCUSNUMNAL() {
        return CCUSNUMNAL;
    }

    @Column(name = "CCUSNUMNAL")
    public String getCCUSSNILS() {
        return CCUSSNILS;
    }

    @Column(name = "DCUSBIRTHDA")
    public LocalDate getDCUSBIRTHDA() {
        return DCUSBIRTHDA;
    }

    // ================ Сеттеры
    public void setICUSNUM(Long ICUSNUM) {
        this.ICUSNUM = ICUSNUM;
    }

    public void setCCUSFLAG(String CCUSFLAG) {
        this.CCUSFLAG = CCUSFLAG;
    }

    public void setCCUSFIRST_NAME(String CCUSFIRST_NAME) {
        this.CCUSFIRST_NAME = CCUSFIRST_NAME;
    }

    public void setCCUSMIDDLE_NAME(String CCUSMIDDLE_NAME) {
        this.CCUSMIDDLE_NAME = CCUSMIDDLE_NAME;
    }

    public void setCCUSLAST_NAME(String CCUSLAST_NAME) {
        this.CCUSLAST_NAME = CCUSLAST_NAME;
    }

    public void setCCUSNUMNAL(Long CCUSNUMNAL) {
        this.CCUSNUMNAL = CCUSNUMNAL;
    }

    public void setCCUSSNILS(String CCUSSNILS) {
        this.CCUSSNILS = CCUSSNILS;
    }

    public void setDCUSBIRTHDA(LocalDate DCUSBIRTHDA) {
        this.DCUSBIRTHDA = DCUSBIRTHDA;
    }

    @Override
    public Long getMarkLongID() {
        return null;
    }
}
