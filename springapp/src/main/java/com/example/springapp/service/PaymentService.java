package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Payment;

public interface PaymentService {
    public boolean addPayment(Payment payment, Long rid, Long cid);
    public List<Payment> getPayments();
    public List<Payment> getAllPayments();
    
}