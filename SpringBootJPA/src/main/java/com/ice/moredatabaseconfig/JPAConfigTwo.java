package com.ice.moredatabaseconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 11.Spring Boot 整合 Jpa 多数据源
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.ice.dao.two", entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanTwo", transactionManagerRef = "platformTransactionManagerTwo")
public class JPAConfigTwo {
    @Autowired
    @Qualifier("dataSourceTwo")
    DataSource dataSourceTwo;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanTwo(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceTwo)
                .properties(jpaProperties.getProperties())
                .persistenceUnit("pUTwo")
                .packages("com.ice.bean")
                .build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerTwo(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(localContainerEntityManagerFactoryBeanTwo(builder).getObject());
    }
}
