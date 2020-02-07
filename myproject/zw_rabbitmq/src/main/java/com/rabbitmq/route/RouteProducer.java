package com.rabbitmq.route;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

/**
 * 路由模式- 生产者
 *   生产者把消息发到 交换机 上 指定个key，消费者 绑定到 队列上 队列绑定到交换机上 ， 在对应 指定的可以 收到消息
 *  -1 在交换机上注册 声明key 只有消费者 注册到这个 队列 标识的key 才能获取到消息
 */
public class RouteProducer {

    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        // 创建交换机 类型为 路由模式
//        exchange: 交换器名称
//        type : 交换器类型 DIRECT("direct"), FANOUT("fanout"), TOPIC("topic"), HEADERS("headers");
//        durable: 是否持久化,durable设置为true表示持久化,反之是非持久化,持久化的可以将交换器存盘,在服务器重启的时候不会丢失信息.
//                autoDelete是否自动删除,设置为TRUE则表是自动删除,自删除的前提是至少有一个队列或者交换器与这交换器绑定,
//                之后所有与这个交换器绑定的队列或者交换器都与此解绑,一般都设置为fase
//        internal 是否内置,如果设置 为true,则表示是内置的交换器,客户端程序无法直接发送消息到这个交换器中,只能通过交换器路由到交换器的方式

        channel.exchangeDeclare("exchange_name","direct");
        //
        channel.basicPublish("exchange_name","routingKey-1",null,"路由模式消息".getBytes());

        connection.close();
        channel.close();
    }
}
