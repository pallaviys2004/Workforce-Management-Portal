package com.springboot.EmployeeManagementSystem.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		http.csrf(csrf->csrf.disable());
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/users/register","/users/verify-otp","/error").permitAll()
				.requestMatchers(HttpMethod.GET,"/employees/**").hasAnyRole("ADMIN","USER")
//				.requestMatchers(HttpMethod.POST,"/employees/**").hasRole("ADMIN")
//				.requestMatchers(HttpMethod.PUT,"/employees/**").hasRole("ADMIN")
//				.requestMatchers(HttpMethod.PATCH,"/employees/**").hasRole("ADMIN")
//				.requestMatchers(HttpMethod.DELETE,"/employees/**").hasRole("ADMIN")
				.requestMatchers("/employees/**").hasRole("ADMIN")//This combines the above four lines but should be written in same order+

				.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
		return http.build();
	}
	@Bean
	UserDetailsService userDetailsService(PasswordEncoder passwordencoder) {
		UserDetails admin=User.withUsername("admin").password(passwordencoder.encode("admin123")).roles("ADMIN").build();
		UserDetails user=User.withUsername("user").password(passwordencoder.encode("user123")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin,user);

	}

}
