package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Customer;

public interface CustomerService {
    public boolean addCustomer(Customer customer);
    public List<Customer> getCustomers();
}