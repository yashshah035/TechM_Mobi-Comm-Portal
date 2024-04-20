package com.example.springapp.service;

import java.util.ArrayList;
import java.util.List;

import com.example.springapp.exception.AddonNotFoundException;
import com.example.springapp.model.Addon;
import com.example.springapp.model.Recharge;
import com.example.springapp.repository.AddonRepository;
import com.example.springapp.repository.RechargeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AddonServiceImpl implements AddonService {

    @Autowired
    AddonRepository addonRepository;

    @Autowired
    RechargeRepository rRepo;

    // Add the Addon to database
    public boolean postAddon(Addon addon) {
        if (addon != null) {
            try {
                addonRepository.save(addon);
                return true;
            } catch (DataAccessException dataAccessException) {
                dataAccessException.printStackTrace();
            }
        }
        return false;
    }

    // Get all addons
    public List<Addon> getAddons() {
        return addonRepository.findAll();
    }

    // Delete addon by addon id
    public boolean deleteAddonById(Long addonId) {
        Addon addon = addonRepository.findById(addonId).orElse(null);

        if (null != addon) {
            List<Recharge> recharges = addon.getRecharges();

            int len = recharges.size();
            if (len > 0) {

                for (Recharge r : recharges) {
                    r.setAddon(null);
                    rRepo.save(r);
                }
            }
            addonRepository.delete(addon);
            return true;

        }

        return false;

    }

    // get addon by id
    @Override
    public Addon getAddonById(Long id) {
        try {
            if (null != id) {
                return addonRepository.findById(id).orElse(null);
            }
        } catch (NullPointerException exception) {
            exception.getMessage();
        }

        return null;
    }

    // Update the addon by the addon id
    @Override
    public boolean updateAddonById(Long addonId, Addon addon) {

        try {
            if (addonRepository.existsById(addonId)) {

                addon.setAddonId(addonId);
                addonRepository.save(addon);
                return true;

            }

        } catch (NullPointerException exception) {
            exception.getMessage();
        }

        return false;

    }

    // Search the addon based on the addon price
    @Override
    public List<Addon> searchByPrice(Double p) {
        List<Addon> addonList = new ArrayList<>(); // Initialize addonList

        List<Addon> aList = addonRepository.findAll();

        for (Addon a : aList) {
            if (a.getAddonPrice() == p) {
                addonList.add(a);
            }
        }

        return addonList; // Return the addonList
    }

}
