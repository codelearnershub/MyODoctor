package com.myodoctor.finalproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Stock {
    public Stock() {
    }

    public Stock(String sku, String name, String brand, double rate, int quantity) {
        this.sku = sku;
        this.name = name;
        this.brand = brand;
        this.rate = rate;
        this.quantity = quantity;
    }

    @Id
    private String sku;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    private double rate;

    private int quantity;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
