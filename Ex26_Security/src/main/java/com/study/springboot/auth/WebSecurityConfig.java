package com.study.springboot.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder().encode("1234"))
				.roles("USER") //ROLE_USER(ROLE_자동추가) 
				.build();
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("1234"))
				.roles("USER","ADMIN")//ROLE_USER,ROLE_ADMIN(ROLE_자동추가) 
				.build();
		
		// 메모리에 사용자 정보 저장
		return new InMemoryUserDetailsManager(user,admin);
	   }
	
	//passwordEncoder()
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories
				.createDelegatingPasswordEncoder();
	}
}
