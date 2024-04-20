package com.example.springapp.service;

import java.util.ArrayList;
import java.util.List;

import com.example.springapp.model.Plan;
import com.example.springapp.model.Recharge;
import com.example.springapp.repository.PlanRepository;
import com.example.springapp.repository.RechargeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    @Autowired
    RechargeRepository rRepo;


    //Add the plan to the plan table in the database
    public boolean addPlan(Plan plan) {
        if (plan != null) {
            planRepository.save(plan);
            return true;
        }
        return false;
    }


    //Get all plan list
    public List<Plan> getPlans() {
        return planRepository.findAll();
    }


    //update the plan using plan object
    public Plan updatePlan(Plan plan) {
        return planRepository.save(plan);
    }


    //Get plan object based on the plan id
    @Override
    public Plan getPlanById(Long id) {
        if (id != null) {
            return planRepository.findById(id).orElse(null);
        }
        return null;
    }


    //Delete the plan from database based on the plan id
    @Override
    public boolean deletePlanById(Long planId) {
        Plan plan = planRepository.findById(planId).orElse(null);

        if (null != plan) {
            List<Recharge> recharges = plan.getRecharges();

            int len = recharges.size();
            if (len > 0) {

                for (Recharge r : recharges) {
                    r.setPlan(null);
                    rRepo.save(r);
                }
            }
            planRepository.delete(plan);
            return true;

        }

        return false;


    }


    //Update the plan based on the plan id
    @Override
    public boolean updatePlanById(Long planId, Plan plan) {
        if (planRepository.existsById(planId)) {
            plan.setPlanId(planId);
            planRepository.save(plan);
            return true;
        }
        return false;
    }


    //Search the plan based on plan price
    @Override
    public List<Plan> searchByPrice(Double p) {
        List<Plan> planList = new ArrayList<>(); // Initialize PlanList

        List<Plan> aList = planRepository.findAll();

        for (Plan a : aList) {
            if (a.getPlanPrice() == p) {
                planList.add(a);
            }
        }

        return planList; // Return the PlanList
    }

}