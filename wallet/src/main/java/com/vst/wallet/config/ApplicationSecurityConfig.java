//package com.vst.wallet.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//
//@EnableWebSecurity
//@Configuration
//public class ApplicationSecurityConfig {
//
//
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withUsername("user").password("{noop}user").roles("USER").build());
//		users.add(User.withUsername("admin").password("{noop}user").roles("ADMIN").build());
//		users.add(User.withUsername("superadmin").password("{noop}user").roles("SUPERADMIN").build());
//	 
//
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(users);
//		return manager;
//	}
//
//
//	@SuppressWarnings("deprecation")
//	public void configure1(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests()
//
//		.requestMatchers("/api/addwallet").hasRole("USER")
//		.requestMatchers("/api/getwalletinfo").hasRole("USER")
//		.requestMatchers("/api/delete/wallet").hasRole("USER")
//		.requestMatchers("/api/updatewallet").hasRole("USER")
//		.requestMatchers("/api/getallwalletinfo").hasRole("USER");
//
//	}
//	
//
//}