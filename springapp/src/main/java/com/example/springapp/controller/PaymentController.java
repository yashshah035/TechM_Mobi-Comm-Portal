package com.example.springapp.controller;



import java.util.List;

import com.example.springapp.exception.CustomerNotFoundException;
import com.example.springapp.exception.RechargeNotFoundException;
import com.example.springapp.model.Payment;
import com.example.springapp.service.PaymentService;

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
public class PaymentController {

    @Autowired
    PaymentService pService;

    @PostMapping("/addpayment/{rid}/{cid}")
    public ResponseEntity<Boolean> postPayment(@RequestBody Payment p,@PathVariable Long rid,@PathVariable Long cid){
        
        return new ResponseEntity<Boolean>(pService.addPayment(p,rid,cid), HttpStatus.CREATED);
    }

    @GetMapping("/getallpayments")
    public List<Payment> getallpayments(){
        return pService.getAllPayments();
    }
    
}
