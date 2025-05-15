/*
package com.example.messageModule.controller;

import com.example.messageModule.service.KafkaConsumerService;
import com.example.messageModule.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;
    private final KafkaConsumerService kafkaConsumerService;

    @Autowired
    public KafkaController(KafkaProducerService kafkaProducerService,
                           KafkaConsumerService kafkaConsumerService) {
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) throws InterruptedException {
        kafkaProducerService.sendMessage(message);
        return "Message sent successfully!";
    }

    @GetMapping("/receive")
    public String getMessage() {
        return kafkaConsumerService.getLastReceivedMessage();
    }
}
*/
