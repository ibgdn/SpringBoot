package com.ice;

import com.ice.activitemq.JmsComponent;
import com.ice.activitemq.Message;
import org.apache.activemq.network.jms.JmsConnector;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

import java.util.Date;

@SpringBootTest
class SpringBootActiveMqApplicationTests {

    @Autowired
	JmsComponent jmsComponent;

	@Test
	void contextLoads() {
		Message message = new Message();
		message.setContent("hello");
		message.setSendDate(new Date());
		jmsComponent.send(message);
	}

}
