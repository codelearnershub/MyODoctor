package com.myodoctor.finalproject.models;


import javax.persistence.*;

@Entity
public class Patient {
    @Id
    private int id;

    @OneToOne
    private Person person;

    private double weight;

    private double height;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(nullable = false)
    private String genotype;

    private String workId;

    @Column(nullable = false)
    private String patientHospitalId;
}