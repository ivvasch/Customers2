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

    public void setCusController(CusController cusController) {
        this.cusController = cusController;
        dsPcus.setTaskContext(getCusController().getTaskContext());
        dsPcus.setRowClass(PCustomers.class);
    }
    public XXIDataSet<PCustomers> getDsPcus() {
        return dsPcus;
    }

    public CusController getCusController() {
        return cusController;
    }

//=========================== Датасет PCusDocum

    public void setDocController(CusDocumController docController) {
        this.docController = docController;
        dsPcusDoc.setTaskContext(getDocController().getTaskContext());
        dsPcusDoc.setRowClass(PCusDocum.class);
    }

    public XXIDataSet<PCusDocum> getDsPcusDoc() {
        return dsPcusDoc;
    }

    public CusDocumController getDocController() {
        return docController;
    }

//===================================== датасет PCusAddr
    public void setCusaddrController(CusAddrController cusaddrController) {
        this.cusaddrController = cusaddrController;
        dsPcusAddr.setTaskContext(getCusaddrController().getTaskContext());
        dsPcusAddr.setRowClass(PCusAddr.class);
    }

    public XXIDataSet<PCusAddr> getDsPcusAddr() {
        return dsPcusAddr;
    }

    public CusAddrController getCusaddrController() {
        return cusaddrController;
    }

//====================================== датасет PCusContacts
    public void setCuscontactsController(CusContactsController cuscontactsController) {
        this.cuscontactsController = cuscontactsController;
        dsPcusContacts.setTaskContext(getCuscontactsController().getTaskContext());
        dsPcusContacts.setRowClass(PCusContacts.class);
    }

    public XXIDataSet<PCusContacts> getDsPcusContacts() {
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
