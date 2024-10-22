package com.cts.bikeapp2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails john = User.builder().username("john").password("{noop}test123").build();
		UserDetails mary = User.builder().username("mary").password("{noop}test123").build();
		UserDetails susan = User.builder().username("susan").password("{noop}test123").build();

		return new InMemoryUserDetailsManager(john, mary, susan);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer ->
					configurer.requestMatchers("/justLogin").hasRole("user")
					.anyRequest().authenticated()
				)
				.formLogin(form ->
						form
						
							.loginPage("/LoginPage")
							.loginProcessingUrl("/authenticateTheUser")
							.permitAll()
						)
						.logout(logout -> logout.permitAll());
		
		return http.build();
	}
}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
//				(authorize) -> authorize.antMatchers().permitAll().anyRequest().authenticated());
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("123").build();
//		return new InMemoryUserDetailsManager(user);
//	}


