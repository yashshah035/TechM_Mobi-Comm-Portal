package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Customer;
import com.example.springapp.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    //Add the customer deatils to the database
    public boolean addCustomer(Customer customer) {
        if(customer!=null){

            try{
                customerRepository.save(customer);
                return true;

            }catch(DataAccessException e){
                e.getMessage();
            }
           
        }
        return false;
    }


    //get all customer list
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
    
}
