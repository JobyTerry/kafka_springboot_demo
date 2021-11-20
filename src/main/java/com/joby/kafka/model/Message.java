package com.joby.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Joby
 * @Date 11/20/2021 4:19 PM
 * @Description
 */
@Data
@AllArgsConstructor
public class Message {

    private String title;

    private String content;

    public Message(){

    }
}
