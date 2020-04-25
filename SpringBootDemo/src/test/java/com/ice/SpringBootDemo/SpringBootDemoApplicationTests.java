package com.ice.SpringBootDemo;

import com.ice.SpringBootDemo.properties.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {
	@Autowired
	Book book;

	@Test
	void contextLoads() {
		// 测试 Spring 属性注入
		System.out.println(book);
	}

}
