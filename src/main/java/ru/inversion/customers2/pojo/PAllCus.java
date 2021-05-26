package ru.inversion.customers2.pojo;

import ru.inversion.dataset.mark.IDMarkable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "ru.inversion.customers2.pojo.PAllCuss")
@Table(name = "allcus")
@NamedNativeQuery(name = "ru.inversion.customers2.pojo.PAllCuss", query = "SELECT icusnum,ccusname,dcusbirthday,ccusnumnal,ccussnils,ph_numnum,e_mail,id_doc,id_doc_tp,doc_ser,doc_num,doc_date,doc_agency,country,post_index,infr_type,infr_name,dom,korp, kv\n" +
        "FROM (SELECT icusnum, ccusname, dcusbirthday, ccusnumnal, ccussnils, ph_numnum, e_mail\n" +
        "         FROM cus\n" +
        "                  INNER JOIN (SELECT icusnum, ph_numnum, e_mail\n" +
        "                              FROM cus_phone\n" +
        "                                       INNER JOIN cus_email USING (icusnum)) USING (icusnum))\n" +
        "         INNER JOIN (SELECT icusnum, id_doc,id_doc_tp,doc_ser,doc_num,doc_date,doc_agency,country,post_index,infr_type,infr_name,dom,korp,kv\n" +
        "                     FROM cus_docum\n" +
        "                              INNER JOIN cus_addr USING (icusnum))\n" +
        "                    USING (icusnum)")
public class PAllCus extends IDMarkable implements Serializable {

    private static final Long serialVersionUID = 26_05_2021_14_14L;

    private Long ICUSNUM;
    private String CCUSNAME;
    private LocalDate DCUSBIRTHDATE;
    private String CCUSNUMNAL;
    private String CCUSSNILS;
    private Long PHNUMNAL;
    private String E_MAIL;
    private Long ID_DOC;
    private Long ID_DOC_TP;
    private String DOC_SER;
    private String DOC_NUM;
    private String DOC;
    private LocalDate DOC_DATE;
    private String DOC_AGENCY;
    private String COUNTRY;
    private String POST_INDEX;
    private String INFR_TYPE;
    private String INFR_NAME;
    private String DOM;
    private String KORP;
    private String KV;
    private String ADDRESS;
    private Long ACT;

    @Id
    @Column(name = "ICUSNUM")
    public Long getICUSNUM() {
        return ICUSNUM;
    }
@Column(name = "CCUSNAME")
    public String getCCUSNAME() {
        return CCUSNAME;
    }
@Column(name = "DCUSBIRTHDATE")
    public LocalDate getDCUSBIRTHDATE() {
        return DCUSBIRTHDATE;
    }
@Column(name = "CCUSNUMNAL")
    public String getCCUSNUMNAL() {
        return CCUSNUMNAL;
    }
@Column(name = "CCUSSNILS")
    public String getCCUSSNILS() {
        return CCUSSNILS;
    }
@Column(name = "PHNUMNAL")
    public Long getPHNUMNAL() {
        return PHNUMNAL;
    }
@Column(name = "E_MAIL")
    public String getE_MAIL() {
        return E_MAIL;
    }
@Column(name = "ID_DOC")
    public Long getID_DOC() {
        return ID_DOC;
    }
@Column(name = "DOC")
    public String getDOC() {
    return DOC_NUM != null ? (getID_DOC_TP() == 21? "Паспорт гр. РФ":
            getID_DOC_TP()== 3?"Св-во о рождении":
            getID_DOC_TP()== 7?"Военный билет":
            getID_DOC_TP()==10? "Паспорт иностранного гр.":
            getID_DOC_TP()==12? "ВНЖ":
            getID_DOC_TP()==13? "Удостоверение беженца":
            getID_DOC_TP()==14?"Временное удостоверение гр. РФ":
            getID_DOC_TP()==15?"РВП":"Усы, лапы и хвост")
            + ", серия: "
            + getDOC_SER() + ", номер: " + getDOC_NUM() : "";
    }
@Column(name = "DOC_DATE")
    public LocalDate getDOC_DATE() {
        return DOC_DATE;
    }
@Column(name = "DOC_AGENCY")
    public String getDOC_AGENCY() {
        return DOC_AGENCY;
    }
@Column(name = "COUNTRY")
    public String getCOUNTRY() {
        return COUNTRY;
    }
@Column(name = "POST_INDEX")
    public String getPOST_INDEX() {
        return POST_INDEX;
    }

    @Column(name = "ADDRESS")
    public String getADDRESS() {
        return getINFR_NAME() == null ? "" : (
                (getINFR_TYPE() != null ? getINFR_TYPE() : "") + ". "
                        + getINFR_NAME() + ", "
                        + (getDOM() != null ? getDOM() : "") + ", "
                        + (getKORP() != null ? getKORP() : "") + ". "
                        + (getKV() != null ? getKV() : "") + ".");
    }

    public String getINFR_TYPE() {
        return INFR_TYPE;
    }

    public String getINFR_NAME() {
        return INFR_NAME;
    }

    public String getDOM() {
        return DOM;
    }

    public String getKORP() {
        return KORP;
    }
    public String getKV() {
        return KV;
    }

    public Long getID_DOC_TP() {
        return ID_DOC_TP;
    }

    public String getDOC_SER() {
        return DOC_SER;
    }

    public String getDOC_NUM() {
        return DOC_NUM;
    }

    public Long getACT() {
        return ACT;
    }
//============================ Сеттеры


    public void setICUSNUM(Long ICUSNUM) {
        this.ICUSNUM = ICUSNUM;
    }

    public void setCCUSNAME(String CCUSNAME) {
        this.CCUSNAME = CCUSNAME;
    }

    public void setDCUSBIRTHDATE(LocalDate DCUSBIRTHDATE) {
        this.DCUSBIRTHDATE = DCUSBIRTHDATE;
    }

    public void setCCUSNUMNAL(String CCUSNUMNAL) {
        this.CCUSNUMNAL = CCUSNUMNAL;
    }

    public void setCCUSSNILS(String CCUSSNILS) {
        this.CCUSSNILS = CCUSSNILS;
    }

    public void setPHNUMNAL(Long PHNUMNAL) {
        this.PHNUMNAL = PHNUMNAL;
    }

    public void setE_MAIL(String e_MAIL) {
        E_MAIL = e_MAIL;
    }

    public void setID_DOC(Long ID_DOC) {
        this.ID_DOC = ID_DOC;
    }

    public void setDOC(String DOC) {
        this.DOC = DOC;
    }

    public void setDOC_DATE(LocalDate DOC_DATE) {
        this.DOC_DATE = DOC_DATE;
    }

    public void setDOC_AGENCY(String DOC_AGENCY) {
        this.DOC_AGENCY = DOC_AGENCY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public void setPOST_INDEX(String POST_INDEX) {
        this.POST_INDEX = POST_INDEX;
    }

    public void setINFR_TYPE(String INFR_TYPE) {
        this.INFR_TYPE = INFR_TYPE;
    }

    public void setINFR_NAME(String INFR_NAME) {
        this.INFR_NAME = INFR_NAME;
    }

    public void setDOM(String DOM) {
        this.DOM = DOM;
    }

    public void setKORP(String KORP) {
        this.KORP = KORP;
    }

    public void setKV(String KV) {
        this.KV = KV;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setACT(Long ACT) {
        this.ACT = ACT;
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

    @Override
    public Long getMarkLongID() {
        return null;
    }
}
