package com.ice;

import com.ice.rabbitmq.fanout.RabbitFanoutConfig;
import org.junit.jupiter.api.Test;
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

}
