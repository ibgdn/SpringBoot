package com.ice.rabbitmq.header;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 5.Spring Boot 整合 RabbitMQ
 */
@Component
public class HeaderReceiver {

    @RabbitListener(queues = "Name Queue")
    public void nameQueue(byte[] message) {
        System.out.println("Header nameQueue: " + new String(message, 0, message.length));
    }

    @RabbitListener(queues = "Age Queue")
    public void ageQueue(byte[] message) {
        System.out.println("Header ageQueue: " + new String(message, 0, message.length));
    }
}
