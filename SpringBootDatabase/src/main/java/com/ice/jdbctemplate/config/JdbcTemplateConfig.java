package com.ice.jdbctemplate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 3.Spring Boot 整合 JdbcTemplate 多数据源
 */
@Configuration
public class JdbcTemplateConfig {
    // @Qualifier 指定使用具体哪个数据源
    @Bean
    JdbcTemplate jdbcTemplateOne(@Qualifier("dataSourceOne") DataSource dataSourceOne) {
        return new JdbcTemplate(dataSourceOne);
    }

    @Bean
    JdbcTemplate jdbcTemplateTwo(@Qualifier("dataSourceTwo") DataSource dataSourceTwo) {
        return new JdbcTemplate(dataSourceTwo);
    }
}
