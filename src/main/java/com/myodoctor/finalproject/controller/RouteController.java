package com.myodoctor.finalproject.controller;

import com.myodoctor.finalproject.models.Route;
import com.myodoctor.finalproject.repositories.IRouteRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RouteController{

        final IRouteRepositories routeRepositories;

        public RouteController(IRouteRepositories routeRepositories) {
            this.routeRepositories = routeRepositories;
        }

        @GetMapping("/route/createRoute")
        public  String createRole() {
            return "Route/CreateRoute";
        }

        @PostMapping("/route/saveRoute")
        public String routeCreation(String route,String description) {
            Route newRoute = new Route(route,description);
            routeRepositories.save(newRoute);
            return "redirect:/routes/allRoute";
        }
        @GetMapping("/routes/allRoute")
        public String allRoute(Model model) {
            model.addAttribute("role", routeRepositories.findAll());
            return "Route/allRoute";
        }
    }
