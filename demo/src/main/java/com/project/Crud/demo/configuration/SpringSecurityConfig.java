package com.project.Crud.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	           // .antMatchers("/rest/addrole/**").hasRole("ADMIN")
	        //    .antMatchers("rest/assignRole/**").hasRole("ADMIN")
	            .antMatchers("/user").hasRole("USER")
	            .antMatchers(HttpMethod.POST,"/rest/assignRole/**").hasRole("ADMIN")
	            .antMatchers("/rest/addrole/**").hasRole("ADMIN")
	            .anyRequest().authenticated()
	            .and()
	            .formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	            .withUser("springuser").password(passwordEncoder().encode("spring123")).roles("USER")
	            .and()
	            .withUser("springadmin").password(passwordEncoder().encode("admin123")).roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
