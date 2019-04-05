package com.chandlertu.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		// and().csrf().disable() 解决 POST 401 或 403 问题。
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic().and().csrf()
				.disable();
	}

}
