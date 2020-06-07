package com.ice.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 10.Spring Boot 整合 Swagger2
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ice.swagger2.controller"))
                // 所有路径
                .paths(PathSelectors.any())
                .build()
                // 配置网站基本信息
                .apiInfo(new ApiInfoBuilder()
                        .description("接口文档描述信息")
                        .title("Swagger2 接口文档")
                        // 联系人
                        .contact(new Contact("contact", "websit.com", "email@email.com"))
                        .version("v1.0")
                        .license("Apache 2.0")
                        .build());
    }
}
