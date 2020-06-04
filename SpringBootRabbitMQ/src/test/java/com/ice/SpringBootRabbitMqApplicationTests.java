package com.ice;

import com.ice.rabbitmq.fanout.RabbitFanoutConfig;
import com.ice.rabbitmq.header.RabbitHeaderConfig;
import com.ice.rabbitmq.topic.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRabbitMqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * direct 方式测试类
     */
    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("RabbitMQ.Direct", "Direct test.");
    }

    /**
     * fanout 方式测试类
     */
    @Test
    void fanout() {
        // routingKey 无效，参数传为 null
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME, null, "Fantout test.");
    }

    /**
     * topic 方式测试类
     */
    @Test
    void topic() {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "first.middle", "First.Middle");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "middle.last", "Middle.Last");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "last.first", "Last.Middle");
    }

    /**
     * header 方式测试类
     */
    @Test
    void header() {
        Message nameMessage1 = MessageBuilder.withBody("Rabbit Name1".getBytes()).setHeader("name", "HEADER").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, nameMessage1);
        Message nameMessage2 = MessageBuilder.withBody("Rabbit Name2".getBytes()).setHeader("name", "header").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, nameMessage2);
        Message ageMessage = MessageBuilder.withBody("Rabbit Age".getBytes()).setHeader("age", "30").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, ageMessage);
    }
}
