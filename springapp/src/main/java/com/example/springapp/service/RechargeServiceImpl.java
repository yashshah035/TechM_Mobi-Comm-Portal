package com.example.springapp.service;

import com.example.springapp.model.Addon;
import com.example.springapp.model.Plan;
import com.example.springapp.model.Recharge;
import com.example.springapp.repository.AddonRepository;
import com.example.springapp.repository.PlanRepository;
import com.example.springapp.repository.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeRepository rechargeRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private AddonRepository addonRepository;


    //Add the recharge to recharge table in database
    @Override
    public Recharge addRecharge(Recharge recharge, Long planId, Long addonId) {
        // Retrieve Plan and set it in the recharge if planId is provided
        if (planId != null) {
            Plan plan = planRepository.findById(planId).orElse(null);
            if (plan != null) {
                recharge.setPlan(plan);

            }
        }

        // Retrieve Addon and set it in the recharge if addonId is provided
        if (addonId != null) {
            Addon addon = addonRepository.findById(addonId).orElse(null);
            if (addon != null) {
                recharge.setAddon(addon);
            }
        }

        // Save the recharge only if at least one condition is met
        if (recharge.getPlan() != null || recharge.getAddon() != null) {
            try {

                return rechargeRepository.save(recharge);

            } catch (DataAccessException e) {
                e.getMessage();
            }

        }

        return null; // Consider a more appropriate response in your application
    }


    //Get all recharges from recharge table in the database
    @Override
    public List<Recharge> getRecharges() {
        return rechargeRepository.findAll();
    }


    //Get recharge details by the recharge id
    @Override
    public Recharge getRechargeById(Long id) {

        try {

            if (id != null) {
                Recharge recharge = rechargeRepository.findById(id).orElse(null);
                return recharge;
            }

        } catch (NullPointerException e) {
            e.getMessage();
        }

        return null;
    }
}
