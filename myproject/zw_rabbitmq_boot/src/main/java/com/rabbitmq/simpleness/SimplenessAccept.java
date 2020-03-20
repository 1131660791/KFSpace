package com.rabbitmq.simpleness;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloQueue")
public class SimplenessAccept {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("接受消息  : " + hello);
    }

}
