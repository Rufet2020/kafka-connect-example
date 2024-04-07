package com.example.kafkaconnectexample.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "")
    public void listen(ConsumerRecord<String, String> record) {

    }

}
