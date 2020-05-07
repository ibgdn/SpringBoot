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
 *  5.Spring Boot 整合 MyBatis 多数据源
 */
@Configuration
@MapperScan(value = "com.ice.mybatis.mapper1", sqlSessionFactoryRef = "sqlSessionFactoryOne", sqlSessionTemplateRef = "sqlSessionTemplateOne")
public class MybatisDataSourceOneConfig {

    @Resource(name = "dataSourceOne")
    DataSource dataSourceOne;

    @Bean
    SqlSessionFactory sqlSessionFactoryOne() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceOne);
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplateOne() {
        return new SqlSessionTemplate(sqlSessionFactoryOne());
    }
}
