package com.ice.rabbitmq.fanout;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 5.Spring Boot 整合 RabbitMQ
 */
@Configuration
public class RabbitFanoutConfig {
    public static final String FANOUTNAME = "RabbitMQ-Fanout";

    @Bean
    Queue queueOne() {
        return new Queue("fanout-queue-one");
    }

    @Bean
    Queue queueTwo() {
        return new Queue("fanout-queue-two");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUTNAME, true, false);
    }

    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }
}
