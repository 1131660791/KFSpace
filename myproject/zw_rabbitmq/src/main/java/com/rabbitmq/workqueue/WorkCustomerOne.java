package com.rabbitmq.workqueue;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

public class WorkCustomerOne {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        final Channel channel = connection.createChannel();

        channel.basicQos(1);
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 定义队列的消费者 自动接收消息
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // 获取消息
                String messge = new String(body);
                System.out.println("消费者one接受消息：" + messge);
                // 手动应答 ， 参数2 false 为接受到消息 true 是拒绝接受消息
                channel.basicAck(envelope.getDeliveryTag(),false);
                //休眠
                try {
                    Thread.sleep( 50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // 监听队列，false表示手动返回完成状态，true表示自动
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
