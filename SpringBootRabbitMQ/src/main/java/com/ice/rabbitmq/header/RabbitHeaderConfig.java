package com.ice.rabbitmq.header;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 5.Spring Boot 整合 RabbitMQ
 */
@Configuration
public class RabbitHeaderConfig {
    public static final String HEADERNAME = "RabbitMQ-Header";

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERNAME, true, false);
    }

    @Bean
    Queue queueName() {
        return new Queue("Name Queue");
    }

    @Bean
    Queue queueAge() {
        return new Queue("Age Queue");
    }

    @Bean
    Binding bindingName() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "HEADER");
        // 匹配 name 相同的 queue
        return BindingBuilder.bind(queueName()).to(headersExchange()).whereAny(map).match();
    }

    @Bean
    Binding bindingAge() {
        // age 存在即可匹配
        return BindingBuilder.bind(queueAge()).to(headersExchange()).where("age").exists();
    }
}

