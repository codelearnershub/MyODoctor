package com.myodoctor.finalproject.models.RegisterModel;

import com.myodoctor.finalproject.models.Route;
import com.myodoctor.finalproject.models.Staff;

public class DeliveryPersonnelRegistrationModel {
    private String route;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
