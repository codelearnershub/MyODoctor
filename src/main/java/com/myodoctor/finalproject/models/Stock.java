package com.myodoctor.finalproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Stock {
    @Id
    private String sku;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    private double rate;

    private int quantity;
}
