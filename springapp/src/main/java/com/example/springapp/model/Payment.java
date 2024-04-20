package com.example.springapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;
    private String status;
    private double totalAmount;
    private Date paymentDate;
    private String modeOfPayment;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="join_customer_id")
    Customer customer;

    @OneToOne()
    @JoinColumn(name="join_recharge_id")
    Recharge recharge;

    public Payment() {
    }

    public Payment(long paymentId, String status, double totalAmount, Date paymentDate, String modeOfPayment,
            Customer customer, Recharge recharge) {
        this.paymentId = paymentId;
        this.status = status;
        this.totalAmount = totalAmount;
        this.paymentDate = paymentDate;
        this.modeOfPayment = modeOfPayment;
        this.customer = customer;
        this.recharge = recharge;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Recharge getRecharge() {
        return recharge;
    }

    public void setRecharge(Recharge recharge) {
        this.recharge = recharge;
    }

    @Override
    public String toString() {
        return "Payment [customer=" + customer + ", modeOfPayment=" + modeOfPayment + ", paymentDate=" + paymentDate
                + ", paymentId=" + paymentId + ", recharge=" + recharge + ", status=" + status + ", totalAmount="
                + totalAmount + "]";
    }


    

    

    
    
}

