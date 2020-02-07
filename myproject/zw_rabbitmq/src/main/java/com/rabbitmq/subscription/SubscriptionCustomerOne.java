package com.rabbitmq.subscription;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.util.ConnectionUtils;

/**
 * 订阅模式-消费者 1
 */
public class SubscriptionCustomerOne {

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare("队列名称", false, false, false, null);
        // 绑定队列到交换机
        channel.queueBind("队列名称", "交换机名称", "");
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);
        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume("队列名称", false, consumer);
        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Recv] Received '" + message + "'");
            Thread.sleep(10);
            // 手动应答
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}