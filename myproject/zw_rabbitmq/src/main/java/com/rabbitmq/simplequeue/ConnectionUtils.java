package com.rabbitmq.simplequeue;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class ConnectionUtils {

    public static Connection getConnection() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("hzw");
        factory.setPassword("123456");
        factory.setPort(15672);
        factory.setVirtualHost("zwvirtualhosts");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}