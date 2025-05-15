package com.example.securityDemo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MockServiceC {
    @Transactional
    String end(String s) {
        int c = 1/0; //here exception is produced and not caught
        return s;
    }
}
