package com.example.notification.kafka;

import com.example.notification.model.request.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String, NotificationRequest> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, NotificationRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJson(NotificationRequest request){

        LOGGER.info(String.format("Message sent %s", request.toString()));

//        Message<NotificationRequest> data = MessageBuilder
//                .withPayload(request)
//                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
//                .build();

        kafkaTemplate.send(topicJsonName, request);
    }


}
