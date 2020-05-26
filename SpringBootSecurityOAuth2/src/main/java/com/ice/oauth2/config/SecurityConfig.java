package com.ice.oauth2.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 14.Spring Security 结合 OAuth2
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("$2a$10$Bf1hi9QF3qgZlIVUK9JAQOaM2WB.H1CE3GncLLTWCS.SD.LDCFc1u").roles("admin")
                .and()
                .withUser("user").password("$2a$10$Bf1hi9QF3qgZlIVUK9JAQOaM2WB.H1CE3GncLLTWCS.SD.LDCFc1u").roles("user");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/oauth2/**")
                .authorizeRequests()
                .antMatchers("/oauth2/**").permitAll()
                .and().csrf().disable();
    }
}
