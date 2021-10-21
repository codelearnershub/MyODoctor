package com.myodoctor.finalproject.controller;

import com.myodoctor.finalproject.models.LoggedInUser.ActiveUserStore;
import com.myodoctor.finalproject.services.Interfaces.IPersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @Autowired
    ActiveUserStore activeUserStore;
    IPersonServices personServices;

//    @GetMapping("/loggedUsers")
//    public Person getLoggedUsers() {
//        List <java.lang.String> person  = new ArrayList<java.lang.String>();
//        var user = activeUserStore.getUsers();
//        return (Person) user;
//    }


}
