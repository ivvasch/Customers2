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

        private Long ICUSNUM;
        private String CCUSFLAG;
        private String CCUSFIRST_NAME;
        private String CCUSMIDDLE_NAME;
        private String CCUSLAST_NAME;
        private Long CCUSNUMNAL;
        private String CCUSSNILS;
        private LocalDate DCUSBIRTHDAY;

    public PCustomers() {
    }

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

    @Column(name = "CCUSSNILS")
    public String getCCUSSNILS() {
        return CCUSSNILS;
    }

    @Column(name = "DCUSBIRTHDAY")
    public LocalDate getDCUSBIRTHDAY() {
        return DCUSBIRTHDAY;
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

    public void setDCUSBIRTHDAY(LocalDate DCUSBIRTHDA) {
        this.DCUSBIRTHDAY = DCUSBIRTHDA;
    }

    @Override
    public Long getMarkLongID() {
        return null;
    }
}
