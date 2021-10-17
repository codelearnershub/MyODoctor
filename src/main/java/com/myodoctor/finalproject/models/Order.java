package com.myodoctor.finalproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {
    public Order() {
    }

    public Order(Patient patient, Date dateOfOrder, double totalPrice, DeliveryPersonnel deliveryPersonnelId) {
        this.patient = patient;
        this.dateOfOrder = dateOfOrder;
        this.totalPrice = totalPrice;
        this.deliveryPersonnelId = deliveryPersonnelId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Patient patient;

    private Date dateOfOrder;
    private double totalPrice;

    @ManyToOne
    private DeliveryPersonnel deliveryPersonnelId;

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public DeliveryPersonnel getDeliveryPersonnelId() {
        return deliveryPersonnelId;
    }

    public void setDeliveryPersonnelId(DeliveryPersonnel deliveryPersonnelId) {
        this.deliveryPersonnelId = deliveryPersonnelId;
    }
}
