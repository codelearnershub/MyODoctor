package com.myodoctor.finalproject.models;

import javax.persistence.*;

public class SupplyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Supply supply;

    @ManyToOne
    private Stock stock;

    private int  quantity;

    private double rate;
}
