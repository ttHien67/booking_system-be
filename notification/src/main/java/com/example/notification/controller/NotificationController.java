package com.example.notification.controller;


import com.example.notification.kafka.KafkaJsonProducer;
import com.example.notification.kafka.KafkaProducer;
import com.example.notification.model.request.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/notification")
public class NotificationController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaJsonProducer kafkaJsonProducer;

    @PostMapping(value = "/sendNotification")
    public ResponseEntity<String> publish(@RequestBody NotificationRequest message){

//        kafkaProducer.sendMessage(message);
        kafkaJsonProducer.sendJson(message);
        return ResponseEntity.ok("Message sent to topic");
    }

////    @Scheduled(fixedDelay = 3000)
//    @KafkaListener(topics = "booking", groupId = "groupId")
////    @PostMapping(value = "/responseNotification")
//    public String response(String request){
//        System.out.print(request);
//        return request;
//    }

}
