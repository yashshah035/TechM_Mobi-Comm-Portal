package com.example.springapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long planId;
    private String planName;
    private String planType;
    private String planValidity;
    private String planDetails;
    private double planPrice;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plan")
    private List<Recharge> recharges;

    public Plan() {
        
    }

    public Plan(long planId, String planName, String planType, String planValidity, String planDetails,
            double planPrice, List<Recharge> recharges) {
        this.planId = planId;
        this.planName = planName;
        this.planType = planType;
        this.planValidity = planValidity;
        this.planDetails = planDetails;
        this.planPrice = planPrice;
        this.recharges = recharges;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getPlanValidity() {
        return planValidity;
    }

    public void setPlanValidity(String planValidity) {
        this.planValidity = planValidity;
    }

    public String getPlanDetails() {
        return planDetails;
    }

    public void setPlanDetails(String planDetails) {
        this.planDetails = planDetails;
    }

    public double getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(double planPrice) {
        this.planPrice = planPrice;
    }

    public List<Recharge> getRecharges() {
        return recharges;
    }

    public void setRecharges(List<Recharge> recharges) {
        this.recharges = recharges;
    }

    @Override
    public String toString() {
        return "Plan [planDetails=" + planDetails + ", planId=" + planId + ", planName=" + planName + ", planPrice="
                + planPrice + ", planType=" + planType + ", planValidity=" + planValidity + ", recharges=" + recharges
                + "]";
    }


    


    

   
    
    
}

