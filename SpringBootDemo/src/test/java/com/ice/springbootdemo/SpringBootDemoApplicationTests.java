package com.ice.springbootdemo;

import com.ice.springbootdemo.properties.Book;
import com.ice.springbootdemo.yaml.RedisCluster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {
	@Autowired
	Book book;

	@Autowired
	RedisCluster redisCluster;

	@Test
	void contextLoads() {
		// 测试 Spring 属性注入
		System.out.println(book);

		// 测试 yaml 配置
		System.out.println(redisCluster);
	}

}
