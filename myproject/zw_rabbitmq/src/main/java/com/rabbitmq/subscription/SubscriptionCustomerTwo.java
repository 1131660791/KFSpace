package com.rabbitmq.subscription;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

/**
 * 订阅模式-消费者 2
 */
public class SubscriptionCustomerTwo {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        // 创建通道
        final Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare("队列名称", false, false, false, null);
        // 绑定队列到交换机
        channel.queueBind("队列名称", EXCHANGE_NAME, "");
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);
        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String massge = new String(body);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 监听队列，手动返回完成
        channel.basicConsume("队列名称", false, consumer);
    }
}
