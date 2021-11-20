package com.joby.kafka.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @Author Joby
 * @Date 11/20/2021 4:22 PM
 * @Description
 */
@Slf4j
@Component
@AllArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(String topic,Object o){
        ListenableFuture<SendResult<String,Object>> future = kafkaTemplate.send(topic,o);
        future.addCallback(
                result -> log.info("send message: {} to [topic: {}] [partition: {}]",o.toString(),result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                result-> log.error("send message error because: {}",result.getMessage())
        );
    }

}
