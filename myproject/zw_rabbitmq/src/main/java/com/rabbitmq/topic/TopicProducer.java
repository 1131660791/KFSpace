package com.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtils;

/**
 * 主题模式
 *  也是和 路由模式一样 生产者将消息发送到交换机 指定key ,消费者绑定到交换机  队列绑定到 交换机 指定key ， 只是将key 变为 通配符  # 匹配多个个 单个词,
 *  * 只匹配一个词
 */
public class TopicProducer {
    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        // 创建交换机 类型为 路由模式
//        exchange: 交换器名称
//        type : 交换器类型 DIRECT("direct"), FANOUT("fanout"), TOPIC("topic"), HEADERS("headers");
//        durable: 是否持久化,durable设置为true表示持久化,反之是非持久化,持久化的可以将交换器存盘,在服务器重启的时候不会丢失信息.
//                autoDelete是否自动删除,设置为TRUE则表是自动删除,自删除的前提是至少有一个队列或者交换器与这交换器绑定,
//                之后所有与这个交换器绑定的队列或者交换器都与此解绑,一般都设置为fase
//        internal 是否内置,如果设置 为true,则表示是内置的交换器,客户端程序无法直接发送消息到这个交换器中,只能通过交换器路由到交换器的方式
        channel.exchangeDeclare("exchange_name","topic");
        channel.basicPublish("exchange_name","key1",null,"主题模式 消息".getBytes());

        connection.close();
        channel.close();
    }
}
