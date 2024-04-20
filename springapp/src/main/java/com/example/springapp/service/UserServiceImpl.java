package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    //Add the new user to the user table in the database
	public boolean addUser(User user) {

        try{

            if(user!=null){
                userRepository.save(user);
                return true;
            }

        }catch(NullPointerException e){
            e.getMessage();
        }
        
		return false;
	}

    

    //Get all user from the users table in the database
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
        
    }
    
}
