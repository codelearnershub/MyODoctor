package com.myodoctor.finalproject.models;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;
}
