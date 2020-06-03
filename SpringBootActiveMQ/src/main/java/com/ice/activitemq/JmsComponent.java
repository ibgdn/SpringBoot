package com.ice.activitemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 3.Spring Boot 整合 ActiveMQ
 */
@Component
public class JmsComponent {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    Queue queue;

    /**
     * 消息的生产者代码
     */
    public void send(Message message) {
        jmsMessagingTemplate.convertAndSend(this.queue, message);
    }

    /**
     * 消息的消费者代码
     */
    @JmsListener(destination = "activeMQ.queue")
    public void receive(Message message) {
        System.out.println("Receive Message: " + message);
    }
}
