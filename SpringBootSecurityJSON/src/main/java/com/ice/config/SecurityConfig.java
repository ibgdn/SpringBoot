package com.ice.config;

import com.ice.filter.CustomizeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 17.Spring Security 使用 JSON 登录
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
        http.addFilterAt(customizeFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CustomizeFilter customizeFilter() throws Exception {
        CustomizeFilter customizeFilter = new CustomizeFilter();
        customizeFilter.setAuthenticationManager(authenticationManagerBean());
        return customizeFilter;
    }
}
