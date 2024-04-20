package com.example.springapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rechargeId;
    private double rechargePrice;
    private String status;
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "join_plan_id")
    private Plan plan;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "join_addon_id")
    private Addon addon;

    

    public Recharge() {
    }

    public Recharge(long rechargeId, double rechargePrice, String status, Date date, Plan plan, Addon addon) {
        this.rechargeId = rechargeId;
        this.rechargePrice = rechargePrice;
        this.status = status;
        this.date = date;
        this.plan = plan;
        this.addon = addon;
    }

    public long getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(long rechargeId) {
        this.rechargeId = rechargeId;
    }

    public double getRechargePrice() {
        return rechargePrice;
    }

    public void setRechargePrice(double rechargePrice) {
        this.rechargePrice = rechargePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Addon getAddon() {
        return addon;
    }

    public void setAddon(Addon addon) {
        this.addon = addon;
    }

    @Override
    public String toString() {
        return "Recharge [addon=" + addon + ", date=" + date + ", plan=" + plan + ", rechargeId=" + rechargeId
                + ", rechargePrice=" + rechargePrice + ", status=" + status + "]";
    }

    
}

