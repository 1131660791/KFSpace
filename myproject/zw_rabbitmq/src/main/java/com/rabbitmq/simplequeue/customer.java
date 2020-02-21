package com.rabbitmq.simplequeue;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

/**
 * 简单队列消费者
 */
public class customer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = ConnectionUtils.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare("queue_name", false, false, false, null);
        DefaultConsumer queueingConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String massge = new String(body);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 监听队列 队列名称,是否自动应答，客户
        channel.basicConsume("queue_name", true, queueingConsumer);
    }
}