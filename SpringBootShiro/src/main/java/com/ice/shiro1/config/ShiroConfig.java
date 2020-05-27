package com.ice.shiro1.config;

import com.ice.shiro1.realm.CustomizeRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 15.整合 Shiro 方式一
 */
@Configuration
public class ShiroConfig {
    @Bean
    CustomizeRealm customizeRealm() {
        return new CustomizeRealm();
    }

    @Bean
    DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customizeRealm());
        return defaultWebSecurityManager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        // 登录地址
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功地址
        shiroFilterFactoryBean.setSuccessUrl("/index");
        Map<String, String> map = new LinkedHashMap<>();
        // 匿名登录
        map.put("/doLogin", "anon");
        // 登录访问
        map.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
}
