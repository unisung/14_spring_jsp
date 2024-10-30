package com.study.springboot.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {
 // spring 6.1 이상 security 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable())
		    .cors(cors -> cors.disable())
		    .authorizeHttpRequests(request -> request
		    		.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
		    		.requestMatchers("/").permitAll()
		    		.requestMatchers("/css/**","/js/**","/img/**").permitAll()
		    		.requestMatchers("/guest/**").permitAll()
		    		.requestMatchers("/member/**").hasAnyRole("USER","ADMIN")
		    		.requestMatchers("/admin/**").hasRole("ADMIN")
		    		.anyRequest().authenticated() //
			);
		
		http.formLogin(formLogin 
				       -> formLogin.permitAll());
		http.logout(logout -> logout.permitAll());
		
		return http.build();
	}
}
