package com.myodoctor.finalproject.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DeliveryPersonnel {
    public DeliveryPersonnel() {
    }

    public DeliveryPersonnel(Staff staff, Route route) {
        this.id = staff.getId();
        this.staff = staff;
        this.route = route;
    }

    @Id
    private int id;

    @OneToOne
    private Staff staff;

    @OneToOne
    private Route route;
  
    public int GetId(){
        return id; 
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}