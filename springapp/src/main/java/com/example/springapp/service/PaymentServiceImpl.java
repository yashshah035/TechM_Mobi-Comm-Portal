package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Customer;
import com.example.springapp.model.Payment;
import com.example.springapp.model.Recharge;
import com.example.springapp.repository.CustomerRepository;
import com.example.springapp.repository.PaymentRepository;
import com.example.springapp.repository.RechargeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RechargeRepository rechargeRepository;

    @Autowired
    private CustomerRepository customerRepository;


    //Get all payments from the databases
    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }


    //Add payment to the database
    @Override
    public boolean addPayment(Payment payment, Long rechargeId, Long customerId) {
        // Validate payment, rechargeId, and customerId
        if (payment == null || rechargeId == null && customerId == null) {
            return false;
        }

        // Set Recharge if rechargeId is provided
        if (rechargeId != null) {
            Recharge recharge = rechargeRepository.findById(rechargeId).orElse(null);
            if (recharge != null) {
                payment.setRecharge(recharge);
            } 
        }

        // Set Customer if customerId is provided
        if (customerId != null) {
            Customer customer = customerRepository.findById(customerId).orElse(null);
            if (customer != null) {
                payment.setCustomer(customer);
            } 
        }

        // Set default status to "Success" and save payment

        try{
            payment.setStatus("Success");
            paymentRepository.save(payment);

            return true;

        }catch(DataAccessException e){
            e.getMessage();
        }

        return false;
        
    }


    //Get all payments from database
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
