package com.datdt.kafkademo.kafka;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "${topic.datdt}", groupId = "${group-id.datdt}")
    void listener(String data) {
        System.out.println("message received: " + data);

    }

}