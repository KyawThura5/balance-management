package com.online.balances.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.online.balances.model.entity.consts.Role;
import com.online.balances.security.LoginSuccessHandler;

@Configuration
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		// Request Authorization
		http.authorizeHttpRequests(req -> {
			req.requestMatchers("/", "/signin", "/signup", "resources/**").permitAll();
			req.requestMatchers("/admin/**").hasAuthority(Role.Admin.name());
			req.requestMatchers("/member/**").hasAuthority(Role.Member.name());
			req.anyRequest().authenticated();

		});

		// login Form
		http.formLogin(form -> {
			form.loginPage("/signin");
			form.successHandler(new LoginSuccessHandler());
		});

		// logout
		http.logout(logout -> {
			logout.logoutUrl("/signout");
			logout.logoutSuccessUrl("/");
		});
		return http.build();

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
