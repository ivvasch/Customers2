package ru.inversion.customers2.pojo;

import javafx.fxml.FXML;
import ru.inversion.dataset.mark.IDMarkable;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ru.inversion.customers2.pojo.PCus_Addr")
@Table(name = "cus_addr")
@NamedNativeQuery(name = "ru.inversion.customers2.pojo.PCus_Addr", query = "SELECT icusnum, id_addr, addr_type, country, post_index, city, infr_type, " +
        "infr_name, dom, korp, kv FROM cus_addr")
public class PCus_Addr extends IDMarkable implements Serializable {

    private static final Long serialVersionUID = 17_05_2021_12_00L;

    private Long ICUSNUM;
    private Long ID_ADDR;
    private Long ADDR_TYPE;
    private String COUNTRY;
    private String POST_INDEX;
    private String CITY;
    private String INFR_TYPE;
    private String INFR_NAME;
    private String DOM;
    private String KORP;
    private String KV;
    private String ADDRESS;
    private String ADDRTYPE;

    public PCus_Addr() {
    }
@Id
@Column(name = "ICUSNUM")
    public Long getICUSNUM() {
        return ICUSNUM;
    }
@Column(name = "ID_ADDR")
    public Long getID_ADDR() {
        return ID_ADDR;
    }
//    @Column(name = "ADDR_TYPE")
    public Long getADDR_TYPE() {
        return ADDR_TYPE;
    }
    @Column(name = "ADDRTYPE")
    public String getADDRTYPE() {
        if(getADDR_TYPE() == 0)
            return "Регистрации";
        if (getADDR_TYPE()==1)
            return "Почтовый";
    return "Фактический";
    }

    @Column(name = "COUNTRY")
    public String getCOUNTRY() {
        return COUNTRY;
    }
@Column(name = "POST_INDEX")
    public String getPOST_INDEX() {
        return POST_INDEX;
    }
@Column(name = "CITY")
    public String getCITY() {
        return CITY;
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
@Column(name = "ADDRESS")
    public String getADDRESS() {
        return getINFR_NAME() == null ? "" : (
                (getINFR_TYPE() != null ? getINFR_TYPE() : "") + ". "
                        + getINFR_NAME() + ", "
                        + (getDOM() != null ? getDOM() : "") + ", "
                        + (getKORP() != null ? getKORP() : "") + ". "
                        + (getKV() != null ? getKV() : "") + ".");
    }

    // =================== Сеттеры

    public void setICUSNUM(Long ICUSNUM) {
        this.ICUSNUM = ICUSNUM;
    }

    public void setID_ADDR(Long ID_ADDR) {
        this.ID_ADDR = ID_ADDR;
    }

    public void setADDR_TYPE(Long ADDR_TYPE) {
        this.ADDR_TYPE = ADDR_TYPE;
    }

    public void setADDRTYPE(String ADDRTYPE) {
        this.ADDRTYPE = ADDRTYPE;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public void setPOST_INDEX(String POST_INDEX) {
        this.POST_INDEX = POST_INDEX;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
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

    @Override
    public Long getMarkLongID() {
        return null;
    }
}
