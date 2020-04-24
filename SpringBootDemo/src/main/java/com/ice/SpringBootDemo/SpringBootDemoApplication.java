package com.ice.SpringBootDemo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
/*
		// 项目启动过程中禁用 banner start
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootDemoApplication.class);
		builder.bannerMode(Banner.Mode.OFF);
		builder.run(args);
		// 项目启动过程中禁用 banner end
*/
	}

}
