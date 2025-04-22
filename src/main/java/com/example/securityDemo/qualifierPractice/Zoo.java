package com.example.securityDemo.qualifierPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
    private final Animal animal;

    public Zoo(@Qualifier("dog") Animal animal) {
        this.animal = animal;
    }

}
