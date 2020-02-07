package com.rabbitmq.simplequeue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtils;

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
        // 参数1 队列名称
        // 参数2 是否持久化队列，队列是 存在于内存中的 如果false 则关闭链接后消失，true 则存在elang 数据库中
        // 参数3 是否排外 如果队列
        // 参数4 是否自动删除
        // 参数5 其他参数
        channel.queueDeclare("queue_name", false, false, false, null);
        // 生产者 投递消息
        channel.basicPublish("", "queue_name", null, "队列消息内容".getBytes());
        // 关闭链接
        connection.close();
        // 关闭通道
        channel.close();
    }
}
