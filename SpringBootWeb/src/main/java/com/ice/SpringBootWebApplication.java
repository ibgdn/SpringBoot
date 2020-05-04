package com.ice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 取消自动化配置，除了可以在 resources/application.properties 里配置，也可以在这里配置
@SpringBootApplication(exclude = WebMvcConfigurer.class)
@ServletComponentScan(basePackages = "com.ice.servlet")
public class SpringBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
