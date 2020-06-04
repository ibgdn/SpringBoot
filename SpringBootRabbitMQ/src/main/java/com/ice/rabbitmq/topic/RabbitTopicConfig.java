package com.ice.rabbitmq.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 5.Spring Boot 整合 RabbitMQ
 */
@Configuration
public class RabbitTopicConfig {
    public static final String TOPICNAME = "RabbitMQ-Topic";

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }

    @Bean
    Queue queueFirst() {
        return new Queue("First Queue");
    }

    @Bean
    Queue queueMiddle() {
        return new Queue("Middle Queue");
    }

    @Bean
    Queue queueLast() {
        return new Queue("Last Queue");
    }

    @Bean
    Binding bindingFirst() {
        return BindingBuilder.bind(queueFirst()).to(topicExchange()).with("first.#");
    }

    @Bean
    Binding bindingMiddle() {
        return BindingBuilder.bind(queueMiddle()).to(topicExchange()).with("#.middle.#");
    }

    @Bean
    Binding bindingLast() {
        return BindingBuilder.bind(queueLast()).to(topicExchange()).with("#.last");
    }
}
