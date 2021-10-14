package com.myodoctor.finalproject.models;

import javax.persistence.*;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;
}