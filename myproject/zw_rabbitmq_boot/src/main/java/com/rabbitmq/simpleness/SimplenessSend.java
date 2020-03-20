package com.rabbitmq.simpleness;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Queue;

@Component
public class SimplenessSend {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "发送消息 " + new Date();
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

}
