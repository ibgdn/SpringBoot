package com.ice.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 5.Spring Boot 整合 MyBatis 多数据源
 */
@Configuration
public class MybatisDataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.one")
    DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    DataSource dataSourceTwo() {
        return DruidDataSourceBuilder.create().build();
    }
}
