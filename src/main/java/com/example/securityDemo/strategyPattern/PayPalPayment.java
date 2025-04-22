package com.example.securityDemo.strategyPattern;

import org.springframework.stereotype.Component;

@Component("payPal")
public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paypal payment: " + amount);
    }
}
