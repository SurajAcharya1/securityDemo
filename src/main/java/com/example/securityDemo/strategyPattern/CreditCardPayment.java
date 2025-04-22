package com.example.securityDemo.strategyPattern;

import org.springframework.stereotype.Component;

@Component("credit")
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Credit card payment: " + amount);
    }
}
