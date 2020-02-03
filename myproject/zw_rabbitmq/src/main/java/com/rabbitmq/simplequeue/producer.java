package com.rabbitmq.simplequeue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * 简单队列 -生产者
 */
public class producer {

    public static void main(String[] args) throws IOException {
        // 获取链接
        Connection connection = ConnectionUtils.getConnection();
        // 开启通道
        Channel channel = connection.createChannel();
        // 创建队列
        channel.queueDeclare("queue_name", false, false, false, null);
        // 生产者 投递消息
        channel.basicPublish("", "queue_name", null, "队列消息内容".getBytes());
        // 关闭链接
        connection.close();
        // 关闭通道
        channel.close();
    }
}
