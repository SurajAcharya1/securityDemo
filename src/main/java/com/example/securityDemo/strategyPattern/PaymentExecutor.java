package com.example.securityDemo.strategyPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentExecutor {
    @Autowired
    private ApplicationContext context;

    public void makePayment(String type, int amount) {
        PaymentStrategy paymentStrategy = context.getBean(type, PaymentStrategy.class);
        paymentStrategy.pay(amount);
    }
}
