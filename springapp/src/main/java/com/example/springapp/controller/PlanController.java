package com.example.springapp.controller;

import java.util.List;

import com.example.springapp.exception.PlanNotFoundException;
import com.example.springapp.model.Plan;
import com.example.springapp.service.PlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PlanController {

    @Autowired
    PlanService pService;

    @PostMapping("/addplan")
    public ResponseEntity<Boolean> postPlan(@RequestBody Plan p) {
        return new ResponseEntity<Boolean>(pService.addPlan(p), HttpStatus.CREATED);
    }

    @GetMapping("/getlistplan")
    public List<Plan> getPlanList() {
        return pService.getPlans();
    }

    @GetMapping("/getplanbyid/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(pService.getPlanById(id));
    }

    @DeleteMapping("/deleteplanbyid/{id}")
    public ResponseEntity<Boolean> deletePlanById(@PathVariable Long id) {
        return ResponseEntity.ok(pService.deletePlanById(id));
    }

    @PutMapping("/update/plan/{planId}")
    public ResponseEntity<Boolean> updatePlan(@PathVariable Long planId, @RequestBody Plan plan) {
        return ResponseEntity.ok(pService.updatePlanById(planId, plan));
    }

    @GetMapping("/searchplan/{price}")
    public List<Plan> serach(@PathVariable Double price) {
        return pService.searchByPrice(price);

    }

}
