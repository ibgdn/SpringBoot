package com.ice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @MapperScan(basePackages = "com.ice.mybatis.mapper") 或者在 UserMapper 添加 @Mapper
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ice.mybatis.mapper")
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

}
