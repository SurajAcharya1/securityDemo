package com.example.securityDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MockServiceB {

    private static final Logger logger = LoggerFactory.getLogger(MockServiceB.class);

    private final MockServiceC mockServiceC;

    public MockServiceB(MockServiceC mockServiceC) {
        this.mockServiceC = mockServiceC;
    }

    DemoFunctionalInterface demoFunctionalInterface = Integer::sum;

    @Transactional
    String intermediate(String s) {
        demoFunctionalInterface.add(5, 6);
        try {
            return mockServiceC.end("asd");
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }
}
