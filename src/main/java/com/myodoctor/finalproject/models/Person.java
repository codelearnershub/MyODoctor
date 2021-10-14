package com.myodoctor.finalproject.models;


import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String username;

    @Column(unique = true)
    private String referenceNo;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String middleName;

    @OneToOne
    private Address address;

    @OneToMany
    private List<Language> language;

    private Date dateOfBirth;

    private String homePhoneNo;

    private String workPhoneNo;

    private String mobileNo;

    private String gender;

    private String profilePictureURL;

    @Column(nullable = false)
    private String email;

    private boolean isActive;

    @Column(nullable = false)
    private String password;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;
}