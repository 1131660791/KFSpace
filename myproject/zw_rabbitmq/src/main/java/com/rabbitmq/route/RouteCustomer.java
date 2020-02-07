package com.rabbitmq.route;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

/**
 * 路由模式 - 消费者
 */
public class RouteCustomer {

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        final Channel channel = connection.createChannel();
        // 参数2 是否持久消息
        channel.queueDeclare("队列名称", false, false, false, null);
        // 队列绑定到交换机 ,参数3 生产者 对应key
        channel.queueBind("队列名称", "交换机名称", "routingKey-1");

        // 多次标记 指定多个key
        channel.queueBind("队列名称", "交换机名称", "routingKey-2");
        // 能者多劳
        channel.basicQos(1);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        // 将消费者注入到交队列 参数2 是否自动应答
        channel.basicConsume("队列名称", false, consumer);
    }
}
