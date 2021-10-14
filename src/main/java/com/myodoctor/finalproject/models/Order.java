package com.myodoctor.finalproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Patient patient;

    private Date dateOfOrder;
    private double totalPrice;

    @ManyToOne
    private DeliveryPersonnel deliveryPersonnelId;


}
