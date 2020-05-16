package com.ice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * 9.Controller 测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ControllerTest2 {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void restTemplate() {
        String springBoot = testRestTemplate.getForObject("/getHello?name={1}", String.class, "SpringBoot");
        System.out.println(springBoot);
    }
}
