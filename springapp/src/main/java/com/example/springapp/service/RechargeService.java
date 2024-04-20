package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Recharge;

public interface RechargeService {
    Recharge addRecharge(Recharge recharge, Long pid, Long aid);
    List<Recharge> getRecharges();
    Recharge getRechargeById(Long id);
}
