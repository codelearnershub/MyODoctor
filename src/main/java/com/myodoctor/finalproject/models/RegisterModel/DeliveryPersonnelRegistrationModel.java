package com.myodoctor.finalproject.models.RegisterModel;

import com.myodoctor.finalproject.models.Route;
import com.myodoctor.finalproject.models.Staff;

public class DeliveryPersonnelRegistrationModel {
    private Staff staff;
    private Route route;

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
