package ru.inversion.customers2.pojo;

import ru.inversion.dataset.mark.IDMarkable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "ru.inversion.customers2.pojo.PCus_Docum")
@Table(name = "cus_doc")
@NamedNativeQuery(name = "ru.inversion.customers2.pojo.PCus_Docum", query = "SELECT icusnum, id_doc, id_doc_tp, doc_ser, doc_num," +
        "doc_date, doc_agency FROM cus_docum")
public class PCusDocum extends IDMarkable implements Serializable {

    private static final Long serialVersionUID = 18_05_2021_09_44L;

    private Long ICUSNUM;
    private Long ID_DOC;
    private Long ID_DOC_TP;
    private String DOC_SER;
    private String DOC_NUM;
    private LocalDate DOC_DATE;
    private String DOC_AGENCY;

    private String PREF;

    private Long ACT;

    public PCusDocum() {
    }

    @Id
    @Column(name = "ICUSNUM")
    public Long getICUSNUM() {
        return ICUSNUM;
    }

    @Column(name = "ID_DOC")
    public Long getID_DOC() {
        return ID_DOC;
    }

    @Column(name = "ID_DOC_TP")
    public Long getID_DOC_TP() {
        return ID_DOC_TP;
    }

    @Column(name = "DOC_SER")
    public String getDOC_SER() {
        return DOC_SER;
    }

    @Column(name = "DOC_NUM")
    public String getDOC_NUM() {
        return DOC_NUM;
    }

    @Column(name = "DOC_DATE")
    public LocalDate getDOC_DATE() {
        return DOC_DATE;
    }

    @Column(name = "DOC_AGENCY")
    public String getDOC_AGENCY() {
        return DOC_AGENCY;
    }


    public Long getACT() {
        return ACT;
    }

    public String getPREF() {
        return "Y";
    }

    // ================ сеттеры

    public void setPREF(String PREF) {
        this.PREF = PREF;
    }
    public void setICUSNUM(Long ICUSNUM) {
        this.ICUSNUM = ICUSNUM;
    }

    public void setID_DOC(Long ID_DOC) {
        this.ID_DOC = ID_DOC;
    }

    public void setID_DOC_TP(Long ID_DOC_TP) {
        this.ID_DOC_TP = ID_DOC_TP;
    }

    public void setDOC_SER(String DOC_SER) {
        this.DOC_SER = DOC_SER;
    }

    public void setDOC_NUM(String DOC_NUM) {
        this.DOC_NUM = DOC_NUM;
    }

    public void setDOC_DATE(LocalDate DOC_DATE) {
        this.DOC_DATE = DOC_DATE;
    }

    public void setDOC_AGENCY(String DOC_AGENCY) {
        this.DOC_AGENCY = DOC_AGENCY;
    }

    public void setACT(Long ACT) {
        this.ACT = ACT;
    }

    @Override
    public Long getMarkLongID() {
        return null;
    }
}
