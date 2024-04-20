package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Plan;

public interface PlanService {
	public boolean addPlan(Plan plan);
    public List<Plan> getPlans();
    public Plan updatePlan(Plan plan);
    public Plan getPlanById(Long id);
	public boolean deletePlanById(Long id);
    public boolean updatePlanById(Long planId, Plan plan);
    public List<Plan> searchByPrice(Double price);
}
