package com.demo.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lwx on 2017/10/7.
 */
public class AppProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for(int i = 0; i<100; i++) {
            service.setMessage("test "+i);
        }
        context.close();
    }
}
