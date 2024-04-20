package com.example.springapp.controller;



import java.util.List;

import com.example.springapp.model.User;
import com.example.springapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    UserService uService;

    @PostMapping("/postuser")
    public ResponseEntity<Boolean> postUser(@RequestBody User u){
        
        return new ResponseEntity<>(uService.addUser(u), HttpStatus.CREATED);
    }
    

    @GetMapping("/getallusers")
    public List<User> getAllUsers(){
        return uService.getAllUsers();
    }
    
}
