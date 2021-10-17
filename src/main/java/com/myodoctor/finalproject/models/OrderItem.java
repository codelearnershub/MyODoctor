package com.myodoctor.finalproject.models;

import javax.persistence.*;

@Entity
public class OrderItem {
    public OrderItem() {
    }

    public OrderItem(Stock stock, Order order, int quantity, double rate) {
        this.stock = stock;
        this.order = order;
        this.quantity = quantity;
        this.rate = rate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Stock stock;

    @ManyToOne
    private Order order;

    private int  quantity;

    private double rate;

    public int getId() {
        return id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
