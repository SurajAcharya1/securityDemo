package com.example.securityDemo.qualifierPractice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("production")
public class Production implements Server {

    @Override
    public void runServer() {

    }
}
