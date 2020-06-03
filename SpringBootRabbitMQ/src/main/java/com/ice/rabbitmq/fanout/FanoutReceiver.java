package com.ice.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 5.Spring Boot 整合 RabbitMQ
 */
@Component
public class FanoutReceiver {
    @RabbitListener(queues = "fanout-queue-one")
    public void fanoutHandlerOne(String message) {
        System.out.println("FanoutHandlerOne: " + message);
    }

    @RabbitListener(queues = "fanout-queue-two")
    public void fanoutHandlerTwo(String message) {
        System.out.println("FanoutHandlerTwo: " + message);
    }
}
