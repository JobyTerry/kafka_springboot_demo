package com.joby.kafka.controller;

import com.joby.kafka.config.KafkaConfig;
import com.joby.kafka.config.KafkaProducer;
import com.joby.kafka.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Joby
 * @Date 11/20/2021 4:50 PM
 * @Description
 */
@RestController
@AllArgsConstructor
@RequestMapping("/message")
public class MessageController {

    private final KafkaConfig kafkaConfig;

    private final KafkaProducer kafkaProducer;

    @GetMapping("/send/topic1")
    public void sendTopic1(Message message){
        kafkaProducer.sendMessage(kafkaConfig.getTopic1(),message);
    }

    @GetMapping("/send/topic2")
    public void sendTopic2(Message message){
        kafkaProducer.sendMessage(kafkaConfig.getTopic2(),message);
    }

}
