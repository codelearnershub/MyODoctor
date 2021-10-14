package com.myodoctor.finalproject.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DeliveryPersonnel {
    @Id
    private int id;

    @OneToOne
    private Staff staff;

    @OneToOne
    private Route route;
}