package com.demo.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by lwx on 2017/10/6.
 */
public class AppConsumer {
    private static final String url = "tcp://192.168.0.103:61616"; //61616是ActiveMQ默认的端口
    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {
        //1. 创建ConnectionFaction
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        //2. 创建Connection
        Connection connection = connectionFactory.createConnection();

        //3. 启动连接
        connection.start();

        //4. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5. 创建一个目标
        Destination destination = session.createQueue(queueName);

        //6. 创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);

        //7. 创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收到的消息："+((TextMessage) message).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //8. 关闭连接
        //connection.close(); //不能直接关闭，因此上面的监听器是个异步的过程，关闭后就接收不到消息
    }
}
