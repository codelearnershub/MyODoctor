package com.myodoctor.finalproject.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Supply {
    public Supply() {
    }

    public Supply(String supplierName, Date dateOfDelivery, double totalPrice) {
        this.supplierName = supplierName;
        this.dateOfDelivery = dateOfDelivery;
        this.totalPrice = totalPrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String supplierName;

    private Date dateOfDelivery;

    private double totalPrice;

    public int getId() {
        return id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
