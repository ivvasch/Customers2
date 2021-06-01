package ru.inversion.customers2.pojo;

import ru.inversion.dataset.mark.IDMarkable;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ru.inversion.customers2.pojo.PCusContacts")
@Table(name = "cuscontacts")
//@NamedNativeQuery(name = "ru.inversion.customers2.pojo.PCusContacts", query = "SELECT email.icusnum, email.id_email, email.e_mail, phone.id_phone, phone.ph_numnum, phone.country\n" +
//        "    FROM (SELECT icusnum, id_email, e_mail FROM XXI.CUS_EMAIL)email INNER JOIN (SELECT icusnum, id_phone, ph_numnum, country FROM XXI.CUS_PHONE)phone\n" +
//        "        ON email.ICUSNUM = phone.ICUSNUM")
@NamedNativeQuery(name = "ru.inversion.customers2.pojo.PCusContacts", query = "SELECT icusnum, id_email, e_mail, id_phone, ph_numnum, country FROM (SELECT cus.icusnum, id_email, e_mail, id_phone, ph_numnum, country FROM cus INNER JOIN (\n" +
        "SELECT email.icusnum, email.id_email, email.e_mail, phone.id_phone, phone.ph_numnum, phone.country FROM (SELECT icusnum, id_email, e_mail FROM XXI.CUS_EMAIL)email\n" +
        "    INNER JOIN (SELECT icusnum, id_phone, ph_numnum, country FROM XXI.CUS_PHONE)phone ON email.ICUSNUM = phone.ICUSNUM)contacts ON contacts.ICUSNUM = cus.ICUSNUM)")
public class PCusContacts extends IDMarkable implements Serializable {

    private static final Long serialVersionUID = 25_05_2021_17_06L;

    private Long ICUSNUM;
    private Long ID_EMAIL;
    private String E_MAIL;
    private Long ID_PHONE;
    private Long PH_NUMNUM;
    private String COUNTRY;
    private Long ACT;

    public PCusContacts() {
    }

    @Id
    @Column(name = "ICUSNUM")
    public Long getICUSNUM() {

        return ICUSNUM;
    }

    @Column(name = "ID_EMAIL")
    public Long getID_EMAIL() {
        return ID_EMAIL;
    }

    @Column(name = "E_MAIL")
    public String getE_MAIL() {
        return E_MAIL;
    }

    @Column(name = "ID_PHONE")
    public Long getID_PHONE() {
        return ID_PHONE;
    }

    @Column(name = "PH_NUMNUM")
    public Long getPH_NUMNUM() {
        return PH_NUMNUM;
    }

    @Column(name = "COUNTRY")
    public String getCOUNTRY() {
        return COUNTRY;
    }

    public Long getACT() {
        return ACT;
    }

    @Override
    public Long getMarkLongID() {
        return null;
    }
    //============== сеттеры

    public void setICUSNUM(Long ICUSNUM) {
        this.ICUSNUM = ICUSNUM;
    }

    public void setID_EMAIL(Long ID_EMAIL) {
        this.ID_EMAIL = ID_EMAIL;
    }

    public void setE_MAIL(String e_MAIL) {
        E_MAIL = e_MAIL;
    }

    public void setID_PHONE(Long ID_PHONE) {
        this.ID_PHONE = ID_PHONE;
    }

    public void setPH_NUMNUM(Long PH_NUMNUM) {
        this.PH_NUMNUM = PH_NUMNUM;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public void setACT(Long ACT) {
        this.ACT = ACT;
    }
}
