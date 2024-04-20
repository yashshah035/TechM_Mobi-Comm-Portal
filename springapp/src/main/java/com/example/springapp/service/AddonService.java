package com.example.springapp.service;

import java.util.List;


import com.example.springapp.model.Addon;

public interface AddonService{
    public boolean postAddon(Addon addon);
    public List<Addon> getAddons();
    public Addon getAddonById(Long id);
    public boolean deleteAddonById(Long id);
    public boolean updateAddonById(Long addonId, Addon addon);
    public List<Addon> searchByPrice(Double price);
}
