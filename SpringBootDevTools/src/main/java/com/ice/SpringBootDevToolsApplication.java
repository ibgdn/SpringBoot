package com.ice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDevToolsApplication {

	public static void main(String[] args) {
		// 通过配置文件或启动类禁用热部署
		System.setProperty("spring.devtools.restart.enabled","false");
		SpringApplication.run(SpringBootDevToolsApplication.class, args);
	}

}
