package com.java.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		// Authenticating a user persisted in the DB
		auth.userDetailsService(userService);

		// In-memory authentication of users
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("admin").password("password").roles("ADMIN") .and()
		 * .withUser("user").password("user").roles("USER");
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll()
			.and()
				.formLogin().permitAll()
			.and()
				.logout().permitAll();
	}

}
