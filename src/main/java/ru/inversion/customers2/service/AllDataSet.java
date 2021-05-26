package ru.inversion.customers2.service;

import ru.inversion.customers2.controller.*;
import ru.inversion.customers2.pojo.*;
import ru.inversion.dataset.XXIDataSet;

public class AllDataSet {
    private XXIDataSet<PCustomers> dsPcus = new XXIDataSet<>();
    private XXIDataSet<PCusDocum> dsPcusDoc = new XXIDataSet<>();
    private XXIDataSet<PCusAddr> dsPcusAddr = new XXIDataSet<>();
    private XXIDataSet<PCusContacts> dsPcusContacts = new XXIDataSet<>();
    private XXIDataSet<PAllCus> dsAllCus = new XXIDataSet<>();
    private CusController cusController;
    private CusDocumController docController;
    private CusAddrController cusaddrController;
    private CusContactsController cuscontactsController;
    private AllCusController allCusController;

//    public void init() {
//        DataLinkBuilder.linkDataSet(getDsPcus(), getDsPcusDoc(), PCustomers::getICUSNUM, "ICUSNUM");
//        DataLinkBuilder.linkDataSet(getDsPcus(), getDsPcusAddr(), PCustomers::getICUSNUM, "ICUSNUM");
//    }

    public void setCusController(CusController cusController) {
        this.cusController = cusController;
    }
    public XXIDataSet<PCustomers> getDsPcus() {
        dsPcus.setTaskContext(getCusController().getTaskContext());
        dsPcus.setRowClass(PCustomers.class);
        return dsPcus;
    }

    public CusController getCusController() {
        return cusController;
    }

//=========================== Датасет PCusDocum

    public void setDocController(CusDocumController docController) {
        this.docController = docController;
    }

    public XXIDataSet<PCusDocum> getDsPcusDoc() {
        dsPcusDoc.setTaskContext(getDocController().getTaskContext());
        dsPcusDoc.setRowClass(PCusDocum.class);
        return dsPcusDoc;
    }

    public CusDocumController getDocController() {
        return docController;
    }

//===================================== датасет PCusAddr
    public void setCusaddrController(CusAddrController cusaddrController) {
        this.cusaddrController = cusaddrController;
    }

    public XXIDataSet<PCusAddr> getDsPcusAddr() {
        dsPcusAddr.setTaskContext(getCusaddrController().getTaskContext());
        dsPcusAddr.setRowClass(PCusAddr.class);
        return dsPcusAddr;
    }

    public CusAddrController getCusaddrController() {
        return cusaddrController;
    }

//====================================== датасет PCusContacts
    public void setCuscontactsController(CusContactsController cuscontactsController) {
        this.cuscontactsController = cuscontactsController;
    }

    public XXIDataSet<PCusContacts> getDsPcusContacts() {
        dsPcusContacts.setTaskContext(getCuscontactsController().getTaskContext());
        dsPcusContacts.setRowClass(PCusContacts.class);
        return dsPcusContacts;
    }

    public CusContactsController getCuscontactsController() {
        return cuscontactsController;
    }

//====================================== датасет PAllCus

    public void setAllCusController(AllCusController allCusController) {
        this.allCusController = allCusController;
    }

    public XXIDataSet<PAllCus> getDsAllCus() {
        dsAllCus.setTaskContext(getAllCusController().getTaskContext());
        dsAllCus.setRowClass(PAllCus.class);
        return dsAllCus;
    }

    public AllCusController getAllCusController() {
        return allCusController;
    }
}
