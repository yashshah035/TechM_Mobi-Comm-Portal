package com.example.springapp.repository;

import com.example.springapp.model.Addon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddonRepository extends JpaRepository<Addon, Long>{
    
}
