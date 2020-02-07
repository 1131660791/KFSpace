package com.rabbitmq.subscription;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

/**
 * 订阅模式 - 生产者
 * 注意：消息发送到没有队列绑定的交换机时，消息将丢失，因为，交换机没有存储消息的能力，消息只能存在在队列中。
 */
public class SubscriptionProducer {

    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtils.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 创建交换机 参数1 交换机名称，参数2 交换机类型 fanout 发布订阅模式
        channel.exchangeDeclare("exchange_name","fanout");
        // 发送消息到交换机
        channel.basicPublish("exchangeName","",null,"消息内容".getBytes());
        // 关闭链接
        connection.close();
        // 关闭通道
        channel.close();
    }
}