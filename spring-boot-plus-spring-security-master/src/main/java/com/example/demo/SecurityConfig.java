package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http //
				.authorizeRequests() //
				.antMatchers("/delete/**").hasRole("MANAGER") //
				.antMatchers("/add").hasRole("MANAGER") //
				.anyRequest().authenticated() //
				.and() //
				.formLogin().permitAll().and() //
				.logout().permitAll();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails basicUser = User.withDefaultPasswordEncoder() //
				.username("user") //
				.password("spring boot learning") //
				.roles("USER") //
				.build();

		UserDetails adminUser = User.withDefaultPasswordEncoder() //
				.username("manager") //
				.password("youtube") //
				.roles("USER", "MANAGER") //
				.build();

		return new InMemoryUserDetailsManager(basicUser, adminUser);
	}
}
