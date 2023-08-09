package com.pluralsight.configservergit;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        // Following line is to disable Cross Site Request Forgery.
        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
    }
}
