package com.rabbitmq.simplequeue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

/**
 * 简单队列消费者
 */
public class customer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("queue_name", false, false, false, null);
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        // 监听队列 队列名称,是否自动应答，客户
        channel.basicConsume("queue_name", true, queueingConsumer);

        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println(delivery.getBody());
        }
    }
}