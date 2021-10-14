package com.myodoctor.finalproject.models;

import javax.persistence.*;

@Entity
public class Address {
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
}
