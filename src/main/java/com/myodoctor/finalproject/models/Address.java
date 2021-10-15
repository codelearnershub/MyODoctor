package com.myodoctor.finalproject.models;

import javax.persistence.*;

@Entity
public class Address {
    public Address() {
    }

    public Address(String streetNumber, String city, String zipPostalCode, String stateProvinceCounty, String country) {
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipPostalCode = zipPostalCode;
        this.stateProvinceCounty = stateProvinceCounty;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String streetNumber;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String zipPostalCode;

    @Column(nullable = false)
    private String stateProvinceCounty;

    @Column(nullable = false)
    private String country;

    public int getId() {
        return id;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public void setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }

    public String getStateProvinceCounty() {
        return stateProvinceCounty;
    }

    public void setStateProvinceCounty(String stateProvinceCounty) {
        this.stateProvinceCounty = stateProvinceCounty;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
