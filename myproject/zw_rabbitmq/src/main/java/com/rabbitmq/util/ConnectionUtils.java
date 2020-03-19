package com.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class ConnectionUtils {

    public static Connection getConnection() throws IOException {
        // 创建链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("hzw");
        factory.setPassword("123456");
        factory.setPort(5672);
        // 获取 VirtualHost
        factory.setVirtualHost("/zwvirtualhosts");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}