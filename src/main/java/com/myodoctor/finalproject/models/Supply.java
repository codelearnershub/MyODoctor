package com.myodoctor.finalproject.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String supplierName;

    private Date dateOfDelivery;

    private double totalPrice;
}
