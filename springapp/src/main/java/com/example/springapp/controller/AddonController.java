package com.example.springapp.controller;



import java.util.List;

import com.example.springapp.exception.AddonNotFoundException;
import com.example.springapp.model.Addon;
import com.example.springapp.service.AddonService;

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
public class AddonController {

    @Autowired
    AddonService aService;

    @PostMapping("/api/addon")
    public ResponseEntity<Boolean> postAddon(@RequestBody Addon a){

        return new ResponseEntity<Boolean>(aService.postAddon(a), HttpStatus.CREATED);
    }

    @GetMapping("/getaddonlist")
    public List<Addon> getAddonList(){
        return aService.getAddons();
    }

    @GetMapping("/getaddonbyid/{id}")
    public ResponseEntity<Addon> getAddonById(@PathVariable Long id) {

        return ResponseEntity.ok(aService.getAddonById(id));
    }

    @DeleteMapping("/deleteaddonbyid/{id}")
    public ResponseEntity<Boolean> deleteAddonById(@PathVariable Long id){
        return ResponseEntity.ok( aService.deleteAddonById(id));
    }


    @PutMapping("/update/addon/{addonId}")
    public ResponseEntity<Boolean> updateAddon(@PathVariable Long addonId,@RequestBody Addon addon){
        return ResponseEntity.ok(aService.updateAddonById(addonId, addon));
    }

    @GetMapping("/search/{price}")
    public List<Addon> serach(@PathVariable Double price){
        return aService.searchByPrice(price);

    }
    
}
