package com.rabbitmq.simplequeue;

import com.rabbitmq.client.Connection;

import java.io.IOException;

public class producer {

    public static void main(String[] args) throws IOException {
        // 获取链接
        Connection connection = ConnectionUtils.getConnection();
        connection.createChannel();
    }
}
