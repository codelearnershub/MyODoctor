package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Benefit;
import com.myodoctor.finalproject.repositories.IBenefitRepositories;
import org.springframework.stereotype.Service;

@Service
public class BenefitService {
    final IBenefitRepositories benefitRepositories;

    public BenefitService(IBenefitRepositories benefitRepositories) {
        this.benefitRepositories = benefitRepositories;
    }

    public void saveBenefit(String name, String description) {
        Benefit benefit = new Benefit(name,description);
        benefitRepositories.save(benefit);
    }

    public void editBenefit(int id,String name, String description) {
        var benefit = benefitRepositories.findById(id).get();
        benefit.setName(name);
        benefit.setDescription(description);
        benefitRepositories.save(benefit);
    }
    public void deleteBenefit(int id) {
        var benefit = benefitRepositories.findById(id).get();
        benefitRepositories.delete(benefit);
    }
}