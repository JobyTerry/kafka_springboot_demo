package com.joby.kafka.config;

import lombok.Data;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author Joby
 * @Date 11/20/2021 4:01 PM
 * @Description
 */
@Data
@Configuration
@PropertySource("classpath:kafka.properties")
@ConfigurationProperties(prefix = "kafka.topic")
public class KafkaConfig {

    private String topic1;

    private String topic2;

    private String consumerGroup1;

    private String consumerGroup2;


    /***
     * @Description create topic in kafka if not exist 
     * @Date  11/20/2021 4:14 PM 
     * @return org.apache.kafka.clients.admin.NewTopic
     */
    @Bean
    public NewTopic topic1(){
        return new NewTopic(topic1,2,(short)1);
    }
    @Bean
    public NewTopic topic2(){
        return new NewTopic(topic2,2,(short)1);
    }

}
