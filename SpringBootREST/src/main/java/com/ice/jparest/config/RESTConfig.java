package com.ice.jparest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

/**
 * 6.自定义 REST 配置。
 * 优先级高于 *.properties 配置文件。
 */
@Configuration
public class RESTConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setBasePath("/config")
                .setMaxPageSize(2);
    }
}
