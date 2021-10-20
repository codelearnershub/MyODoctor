package com.myodoctor.finalproject.models;

import javax.persistence.*;

@Entity
public class SupplyItem {
    public SupplyItem() {
    }

    public SupplyItem(Supply supply, Stock stock, int quantity, double rate) {
        this.supply = supply;
        this.stock = stock;
        this.quantity = quantity;
        this.rate = rate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Supply supply;

    @ManyToOne
    private Stock stock;

    private int  quantity;

    private double rate;

    public int getId() {
        return id;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
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
