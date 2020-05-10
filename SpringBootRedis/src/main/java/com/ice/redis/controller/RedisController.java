package com.ice.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2.Spring Boot 整合 Redis
 */
@RestController
public class RedisController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "setRedis")
    public void setRedis() {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("name", "ice");
    }

    @GetMapping(value = "getRedis")
    public void getRedis() {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        System.out.println(stringStringValueOperations.get("name"));
    }
}
