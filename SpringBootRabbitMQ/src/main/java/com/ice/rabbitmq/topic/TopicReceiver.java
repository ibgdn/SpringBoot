package com.ice.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 5.Spring Boot 整合 RabbitMQ
 */
@Component
public class TopicReceiver {
    @RabbitListener(queues = "First Queue")
    public void first(String message) {
        System.out.println("RabbitMQ first: " + message);
    }

    @RabbitListener(queues = "Middle Queue")
    public void middle(String message) {
        System.out.println("RabbitMQ middle: " + message);
    }

    @RabbitListener(queues = "Last Queue")
    public void last(String message) {
        System.out.println("RabbitMQ last: " + message);
    }
}
