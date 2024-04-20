package com.example.springapp.controller;

import com.example.springapp.exception.AddonNotFoundException;
import com.example.springapp.exception.PlanNotFoundException;
import com.example.springapp.exception.RechargeNotFoundException;
import com.example.springapp.model.Recharge;
import com.example.springapp.service.RechargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class RechargeController {

  @Autowired
  RechargeService rService;

  @PostMapping("/postrecharge/{pid}/{aid}")
  public ResponseEntity<Recharge> postRecharge(@RequestBody Recharge r, @PathVariable Long pid,
      @PathVariable Long aid){
        return new ResponseEntity<Recharge>(rService.addRecharge(r,pid,aid), HttpStatus.CREATED);
  }



  @GetMapping("/getRechargeById/{id}")
  public ResponseEntity<Recharge> getRechargeById(@PathVariable Long id){
    return ResponseEntity.ok(rService.getRechargeById(id));
  }
  

}
