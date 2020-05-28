package com.ice.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 16.整合 Shiro 方式二
 */
@Configuration
public class ShiroConfig {
    @Bean
    Realm realm() {
        TextConfigurationRealm textConfigurationRealm = new TextConfigurationRealm();
        textConfigurationRealm.setUserDefinitions("shiro=123456,user \n admin=123456,admin");
        textConfigurationRealm.setRoleDefinitions("admin=read,write \n user=read");
        return textConfigurationRealm;
    }

    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        defaultShiroFilterChainDefinition.addPathDefinition("/doLogin", "anon");
        defaultShiroFilterChainDefinition.addPathDefinition("/**","authc");
        return defaultShiroFilterChainDefinition;
    }
}
