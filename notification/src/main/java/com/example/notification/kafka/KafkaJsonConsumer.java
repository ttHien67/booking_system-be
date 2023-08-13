package com.example.notification.kafka;

import com.example.notification.model.request.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private SimpMessagingTemplate template;

    @Autowired
    public KafkaJsonConsumer(SimpMessagingTemplate template) {
        this.template = template;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(NotificationRequest request){
        LOGGER.info(String.format("Json message received %s", request.toString()));

        template.convertAndSendToUser(request.getId(),"/private", request);

        
    }
}
