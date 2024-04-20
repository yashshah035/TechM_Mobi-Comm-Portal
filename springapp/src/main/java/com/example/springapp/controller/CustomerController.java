package com.example.springapp.controller;



import com.example.springapp.model.Customer;
import com.example.springapp.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {

    @Autowired
    CustomerService cService;

    @PostMapping("/postcustomer")
    public ResponseEntity<Boolean> postCustomer(@RequestBody Customer c){
        
        return new ResponseEntity<Boolean>(cService.addCustomer(c), HttpStatus.CREATED);
    }
    
}
