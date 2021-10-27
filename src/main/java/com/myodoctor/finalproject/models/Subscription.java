package com.myodoctor.finalproject.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subscription {
    public Subscription() {
    }

    public Subscription(Plan plan, Patient patient, List<Patient> beneficiaries, boolean isActive) {
        this.plan = plan;
        this.patient = patient;
        this.beneficiaries = beneficiaries;
        this.isActive = isActive;
    }

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

    public int getId() {
        return id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Patient> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Patient> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
