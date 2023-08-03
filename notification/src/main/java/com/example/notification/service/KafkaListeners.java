package com.example.notification.service;

import com.example.notification.model.request.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    @KafkaListener(topics = "booking", groupId = "groupId")
//    public void listener(String data){
////        kafkaTemplate.send("response", data);
////        return new BaseResponse(data, "0", "success");
//    }
}
