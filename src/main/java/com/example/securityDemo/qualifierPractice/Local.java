package com.example.securityDemo.qualifierPractice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("local")
public class Local implements Server {
    @Override
    public void runServer() {
        System.out.println("Local runServer");
    }
}
