package com.myodoctor.finalproject.models;

import javax.persistence.*;

@Entity
public class Language {
    public Language() {
    }

    public Language(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}