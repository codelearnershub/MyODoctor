package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Benefit;
import com.myodoctor.finalproject.models.Plan;
import com.myodoctor.finalproject.repositories.IPlanRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServices {
    final IPlanRepositories planRepositories;

    public PlanServices(IPlanRepositories planRepositories) {
        this.planRepositories = planRepositories;
    }

    public void savePlan(String name,double rate,List<Benefit> benefit) {
        Plan plan = new Plan(name,rate,benefit);
        planRepositories.save(plan);
    }
}
