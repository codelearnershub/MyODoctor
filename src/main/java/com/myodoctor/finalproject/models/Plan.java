package com.myodoctor.finalproject.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    private double rate;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "plan_benefit", joinColumns = @JoinColumn(name = "plan_id"), inverseJoinColumns = @JoinColumn(name = "benefit_id"))
    List<Benefit> benefits;
}
