package com.benchark.proxy.custom_implementation;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void pay(String user, double amount) {
        System.out.println("Processing payment...");
    }
}
