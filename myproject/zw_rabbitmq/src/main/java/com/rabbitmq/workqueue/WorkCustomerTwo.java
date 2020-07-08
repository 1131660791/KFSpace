package com.rabbitmq.workqueue;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

public class WorkCustomerTwo {
    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        final Channel channel = connection.createChannel();
        // 能者多劳处理完成
        channel.basicQos(1);
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String massge = new String(body);
                System.out.println("消费者two接受消息：" + massge);
                // 应答 参数2 确定应答消息
                channel.basicAck(envelope.getDeliveryTag(),false);
                //休眠
                try {
                    Thread.sleep( 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // 监听队列，false表示手动返回完成状态，true表示自动
        channel.basicConsume(QUEUE_NAME, false, consumer);


    }
}
