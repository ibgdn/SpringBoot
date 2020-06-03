package com.ice.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 5.Spring Boot 整合 RabbitMQ
 * direct 消费者
 */
@Component
public class DirectReceiver {
    @RabbitListener(queues = "RabbitMQ.Direct")
    public void directHandler(String message) {
        System.out.println("DirectHandler: " + message);
    }
}
