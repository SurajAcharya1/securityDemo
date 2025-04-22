package com.example.securityDemo.factoryPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {
    @Autowired
    ApplicationContext context;

    public NotificationService getNotificationService(String type) {
        return context.getBean(type, NotificationService.class);
    }
}
