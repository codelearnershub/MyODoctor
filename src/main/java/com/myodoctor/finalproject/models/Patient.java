package com.myodoctor.finalproject.models;


import javax.persistence.*;

@Entity
public class Patient {
    public Patient() {
    }

    public Patient(Person person, double weight, double height, String bloodGroup, String genotype, String workId, String patientHospitalId) {
        this.id = person.getId();
        this.person = person;
        this.weight = weight;
        this.height = height;
        this.bloodGroup = bloodGroup;
        this.genotype = genotype;
        this.workId = workId;
        this.patientHospitalId = patientHospitalId;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGenotype() {
        return genotype;
    }

    public void setGenotype(String genotype) {
        this.genotype = genotype;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getPatientHospitalId() {
        return patientHospitalId;
    }

    public void setPatientHospitalId(String patientHospitalId) {
        this.patientHospitalId = patientHospitalId;
    }
}