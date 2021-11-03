package com.myodoctor.finalproject.controller;

import com.myodoctor.finalproject.models.Benefit;
import com.myodoctor.finalproject.repositories.IBenefitRepositories;
import com.myodoctor.finalproject.repositories.IPlanRepositories;
import com.myodoctor.finalproject.services.Implementations.PlanServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PlanController {
    final PlanServices planServices;
    final IPlanRepositories planRepositories;
    final IBenefitRepositories benefitRepositories;

    public PlanController(PlanServices planServices, IPlanRepositories planRepositories, IBenefitRepositories benefitRepositories) {
        this.planServices = planServices;
        this.planRepositories = planRepositories;
        this.benefitRepositories = benefitRepositories;
    }

    @GetMapping("plan/createPlan")
    public String plan(Model model) {
        model.addAttribute("allBenefit", benefitRepositories.findAll());
        return "Plan/createPlan";
    }

    @PostMapping("/plan/savePlan")
    public String savePlan(String rate,String name, List<Benefit> benefit) {
        double newRate = Double.parseDouble(rate);
        planServices.savePlan(name,newRate,benefit);
        return "redirect:/plan/allPlan";
    }

    @GetMapping("/plan/allPlan")
    public String allPlan(Model model) {
        model.addAttribute("allPlan",planRepositories.findAll());
        return "Plan/allPlan";
    }
}