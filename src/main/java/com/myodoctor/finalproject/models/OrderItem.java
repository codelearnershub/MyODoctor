package com.myodoctor.finalproject.models;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Stock stock;

    @ManyToOne
    private Order order;

    private int  quantity;

    private double rate;
}
