package com.example.securityDemo.factoryPattern;

import org.springframework.stereotype.Service;

@Service("email")
public class SendEmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email message: " + message);
    }
}
