package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.User;

public interface UserService {
    public boolean addUser(User user);
    public List<User> getAllUsers();
}
