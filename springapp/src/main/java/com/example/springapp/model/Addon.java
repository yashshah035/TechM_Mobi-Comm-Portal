package com.example.springapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Addon {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long addonId;
    private String addonName;
    private String addonDetails;
    private String addonValidity;
    private double addonPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addon")
    @JsonIgnore
    private List<Recharge> recharges;

    public Addon() {
    }

    public Addon(long addonId, String addonName, String addonDetails, String addonValidity, double addonPrice,
            List<Recharge> recharges) {
        this.addonId = addonId;
        this.addonName = addonName;
        this.addonDetails = addonDetails;
        this.addonValidity = addonValidity;
        this.addonPrice = addonPrice;
        this.recharges = recharges;
    }

    public long getAddonId() {
        return addonId;
    }

    public void setAddonId(long addonId) {
        this.addonId = addonId;
    }

    public String getAddonName() {
        return addonName;
    }

    public void setAddonName(String addonName) {
        this.addonName = addonName;
    }

    public String getAddonDetails() {
        return addonDetails;
    }

    public void setAddonDetails(String addonDetails) {
        this.addonDetails = addonDetails;
    }

    public String getAddonValidity() {
        return addonValidity;
    }

    public void setAddonValidity(String addonValidity) {
        this.addonValidity = addonValidity;
    }

    public double getAddonPrice() {
        return addonPrice;
    }

    public void setAddonPrice(double addonPrice) {
        this.addonPrice = addonPrice;
    }

    public List<Recharge> getRecharges() {
        return recharges;
    }

    public void setRecharges(List<Recharge> recharges) {
        this.recharges = recharges;
    }

    @Override
    public String toString() {
        return "Addons [addonDetails=" + addonDetails + ", addonId=" + addonId + ", addonName=" + addonName
                + ", addonPrice=" + addonPrice + ", addonValidity=" + addonValidity + ", recharges=" + recharges + "]";
    }

    
}

