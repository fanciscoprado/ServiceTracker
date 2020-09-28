package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Car implements Serializable {
    private String make, modle, coustomerName, phone;
    private  int year, vin;
    private ArrayList<ServiceDone> serviceDoneArrayList = new ArrayList<ServiceDone>();

    public Car(String make, String modle, String coustomerName, String phone, int year, int vin) {
        this.make = make;
        this.modle = modle;
        this.coustomerName = coustomerName;
        this.phone = phone;
        this.year = year;
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public String getModle() {
        return modle;
    }

    public String getCoustomerName() {
        return coustomerName;
    }

    public String getPhone() {
        return phone;
    }

    public int getYear() {
        return year;
    }

    public int getVin() {
        return vin;
    }

    public void setServiceDoneArrayList(ServiceDone temp) {
        this.serviceDoneArrayList.add(temp);
    }

    public ArrayList<ServiceDone> getServiceDoneArrayList() {
        return serviceDoneArrayList;
    }
}
