package ru.inversion.customers2.service;

import ru.inversion.customers2.controller.CUSADDRController;
import ru.inversion.customers2.controller.CUSCONTACTSController;
import ru.inversion.customers2.controller.CUSController;
import ru.inversion.customers2.controller.CUSDOCUMController;
import ru.inversion.customers2.pojo.PCusAddr;
import ru.inversion.customers2.pojo.PCusContacts;
import ru.inversion.customers2.pojo.PCusDocum;
import ru.inversion.customers2.pojo.PCustomers;
import ru.inversion.dataset.DataLinkBuilder;
import ru.inversion.dataset.XXIDataSet;

public class AllDataSet {
    private XXIDataSet<PCustomers> dsPcus = new XXIDataSet<>();
    private XXIDataSet<PCusDocum> dsPcusDoc = new XXIDataSet<>();
    private XXIDataSet<PCusAddr> dsPcusAddr = new XXIDataSet<>();
    private XXIDataSet<PCusContacts> dsPcusContacts = new XXIDataSet<>();
    private CUSController cusController;
    private CUSDOCUMController docController;
    private CUSADDRController cusaddrController;

    private CUSCONTACTSController cuscontactsController;

//    public void init() {
//        DataLinkBuilder.linkDataSet(getDsPcus(), getDsPcusDoc(), PCustomers::getICUSNUM, "ICUSNUM");
//        DataLinkBuilder.linkDataSet(getDsPcus(), getDsPcusAddr(), PCustomers::getICUSNUM, "ICUSNUM");
//    }

    public void setCusController(CUSController cusController) {
        this.cusController = cusController;
    }
    public XXIDataSet<PCustomers> getDsPcus() {
        dsPcus.setTaskContext(getCusController().getTaskContext());
        dsPcus.setRowClass(PCustomers.class);
        return dsPcus;
    }

    public CUSController getCusController() {
        return cusController;
    }

//=========================== Датасет PCusDocum

    public void setDocController(CUSDOCUMController docController) {
        this.docController = docController;
    }

    public XXIDataSet<PCusDocum> getDsPcusDoc() {
        dsPcusDoc.setTaskContext(getDocController().getTaskContext());
        dsPcusDoc.setRowClass(PCusDocum.class);
        return dsPcusDoc;
    }

    public CUSDOCUMController getDocController() {
        return docController;
    }

//===================================== датасет PCusAddr
    public void setCusaddrController(CUSADDRController cusaddrController) {
        this.cusaddrController = cusaddrController;
    }

    public XXIDataSet<PCusAddr> getDsPcusAddr() {
        dsPcusAddr.setTaskContext(getCusaddrController().getTaskContext());
        dsPcusAddr.setRowClass(PCusAddr.class);
        return dsPcusAddr;
    }

    public CUSADDRController getCusaddrController() {
        return cusaddrController;
    }

//====================================== датасет PCusContacts
    public void setCuscontactsController(CUSCONTACTSController cuscontactsController) {
        this.cuscontactsController = cuscontactsController;
    }

    public XXIDataSet<PCusContacts> getDsPcusContacts() {
        dsPcusContacts.setTaskContext(getCuscontactsController().getTaskContext());
        dsPcusContacts.setRowClass(PCusContacts.class);
        return dsPcusContacts;
    }

    public CUSCONTACTSController getCuscontactsController() {
        return cuscontactsController;
    }
}
