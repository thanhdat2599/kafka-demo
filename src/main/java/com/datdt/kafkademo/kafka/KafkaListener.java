package com.datdt.kafkademo.kafka;

import com.datdt.kafkademo.dto.MessageDTO;
import com.datdt.kafkademo.exception.RetryableException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {
    @Autowired
    private ObjectMapper objectMapper;

    @RetryableTopic(attempts = "${kafka.topic.datdt.retry.attempts:'3'}",
            backoff = @Backoff(delay = 700, maxDelay = 3000, multiplier = 3),
            include = RetryableException.class
    )
    @org.springframework.kafka.annotation.KafkaListener(topics = "${kafka.topic.datdt.name}", groupId = "${kafka.group-id.group1}")
    void listener(String data) {
        try {
            MessageDTO messageDTO = objectMapper.readValue(data, MessageDTO.class);
            System.out.println("object: " + messageDTO);
        } catch (JsonProcessingException e) {
            throw new RetryableException(null, null, e);
        }
        System.out.println("message received: " + data);

    }

}