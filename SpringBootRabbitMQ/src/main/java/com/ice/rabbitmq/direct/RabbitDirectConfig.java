package com.ice.rabbitmq.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 5.Spring Boot 整合 RabbitMQ
 */
@Configuration
public class RabbitDirectConfig {
    public static final String DIRECTNAME = "RabbitMQ-Direct";

    @Bean
    Queue queue() {
        return new Queue("RabbitMQ.Direct");
    }

    @Bean
    DirectExchange directExchange() {
        // DIRECTNAME, 重启后是否依然有效，长期未使用是否自动删除
        return new DirectExchange(DIRECTNAME, true, false);
    }

    @Bean
    Binding binding() {
        // 将 queue 、directchange 绑定到一起
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}
