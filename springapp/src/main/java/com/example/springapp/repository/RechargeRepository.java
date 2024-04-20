package com.example.springapp.repository;

import com.example.springapp.model.Recharge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeRepository extends JpaRepository<Recharge, Long> {
    
}
