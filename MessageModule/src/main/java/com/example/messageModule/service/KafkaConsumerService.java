/*
package com.example.messageModule.service;

import lombok.Getter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Getter
@Service
public class KafkaConsumerService {

    private String lastReceivedMessage;

    @KafkaListener(topics = "securityDemo", groupId = "my-group")
    public void listen(String message) {
        lastReceivedMessage = message;
    }

}
*/
