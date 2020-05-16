package com.ice;

import com.ice.servicetest.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 8.Service 测试
 */
@SpringBootTest
public class ServiceTest {

    @Autowired(required = false)
    TestService testService;

    @Test
    public void serviceTest() {
        String springBoot = testService.sayHello("SpringBoot");
    }
}
