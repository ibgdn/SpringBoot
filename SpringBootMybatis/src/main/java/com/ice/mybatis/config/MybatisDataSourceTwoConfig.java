package com.ice.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 5.Spring Boot 整合 MyBatis 多数据源
 */
@Configuration
@MapperScan(value = "com.ice.mybatis.mapper2", sqlSessionFactoryRef = "sqlSessionFactoryTwo", sqlSessionTemplateRef = "sqlSessionTemplateTwo")
public class MybatisDataSourceTwoConfig {
    @Resource(name = "dataSourceTwo")
    DataSource dataSourceTwo;

    @Bean
    SqlSessionFactory sqlSessionFactoryTwo() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceTwo);
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplateTwo() {
        return new SqlSessionTemplate(sqlSessionFactoryTwo());
    }

}
