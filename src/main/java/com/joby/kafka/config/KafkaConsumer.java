package com.joby.kafka.config;

import com.joby.kafka.model.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author Joby
 * @Date 11/20/2021 4:23 PM
 * @Description
 */
@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    private final KafkaConfig kafkaConfig;

    @KafkaListener(topics={"#{kafkaConfig.getTopic1()}"}, groupId = "#{kafkaConfig.getConsumerGroup1()}")
    public void onMessage1(ConsumerRecord<?, ?> consumerRecord){
        log.info("onMessage1 consume message: {} from [topic: {}] [partition: {}]",consumerRecord.value().toString(),consumerRecord.topic(), consumerRecord.partition());
    }

    @KafkaListener(topics={"#{kafkaConfig.getTopic2()}"}, groupId = "#{kafkaConfig.getConsumerGroup2()}")
    public void onMessage2(Message message){
        log.info("onMessage2 consume message: {} ",message.toString());
    }

}

