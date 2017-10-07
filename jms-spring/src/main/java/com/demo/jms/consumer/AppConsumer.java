package com.demo.jms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lwx on 2017/10/7.
 */
public class AppConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
