package com.example.springapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long customerId;
    private String customerName;
    private String address;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="join_user_id")
    User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    private List<Payment> payments;

    public Customer() {
    }

    public Customer(long customerId, String customerName, String address, User user, List<Payment> payments) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.user = user;
        this.payments = payments;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Customer [address=" + address + ", customerId=" + customerId + ", customerName=" + customerName
                + ", payments=" + payments + ", user=" + user + "]";
    }

    
}

