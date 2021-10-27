package com.myodoctor.finalproject.controller;

import com.myodoctor.finalproject.models.Benefit;
import com.myodoctor.finalproject.repositories.IBenefitRepositories;
import com.myodoctor.finalproject.services.Implementations.BenefitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BenefitController {
    final IBenefitRepositories benefitRepositories;
    final BenefitService benefitService;

    public BenefitController(IBenefitRepositories benefitRepositories, BenefitService benefitService) {
        this.benefitRepositories = benefitRepositories;
        this.benefitService = benefitService;
    }

    @GetMapping("/plan/createBenefit")
    public String createBenefit() {
        return "Benefit/createBenefit";
    }

    @PostMapping("/benefit/saveBenefit")
    public String savePlan(String name,String description) {
        benefitService.saveBenefit(name,description);
        return "redirect:/benefit/allBenefits";
    }

    @GetMapping("/benefit/allBenefits")
    public String allBenefit(Model model) {
        model.addAttribute("benefits", benefitRepositories.findAll());
        return "Benefit/allBenefit";
    }

    @GetMapping("/benefit/edit/{id}")
    public String benefit(@PathVariable("id") int id,Model model) {
        model.addAttribute("benefit", benefitRepositories.findById(id));
        return "Benefit/editBenefit";
    }

    @PostMapping("/benefit/updateBenefit")
    public String editBenefit(int id,String name,String description) {
         benefitService.editBenefit(id,name,description);
        return "redirect:/benefit/allBenefits";
    }

    @GetMapping("delete/benefit/{id}")
    public String deleteBenefit(@PathVariable("id") int id) {
        benefitService.deleteBenefit(id);
        return "redirect:/benefit/allBenefits";
    }
}
