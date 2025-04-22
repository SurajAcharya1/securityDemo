package com.example.securityDemo.factoryPattern;

import org.springframework.stereotype.Service;

@Service("sms")
public class SendSmsNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS message: " + message);
    }
}
