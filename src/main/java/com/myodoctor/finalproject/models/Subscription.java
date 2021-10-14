package com.myodoctor.finalproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Plan plan;

    @ManyToOne
    private Patient patient;

    @OneToMany
    private List<Patient> beneficiaries;

    private boolean isActive;

}
