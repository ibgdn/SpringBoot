package com.ice.servicetest;

import org.springframework.stereotype.Service;

/**
 * 8.Service 测试
 */
@Service
public class TestService {
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
