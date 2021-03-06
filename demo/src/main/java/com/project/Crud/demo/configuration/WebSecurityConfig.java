package com.project.Crud.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers("/authenticate").permitAll()
				.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
						"/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui", "/swagger-ui.html")
				.permitAll()
				.antMatchers(HttpMethod.POST, "/rest/Category").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/rest/Category").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/rest/Category/deletecategory/{id}").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/rest/Category/getallcategory").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/rest/Category/editCategory").hasAuthority("ADMIN")
				
				.antMatchers(HttpMethod.POST, "/rest/product/createProduct").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/rest/product/getAllproduct").hasAnyAuthority("ADMIN","USER")
				.antMatchers(HttpMethod.DELETE, "/rest/product/deletecategory/{id}").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/rest/product/getProductByname").hasAnyAuthority("ADMIN","USER")
				.antMatchers(HttpMethod.POST, "/rest/product/editproduct").hasAuthority("ADMIN")
				
				.antMatchers(HttpMethod.POST, "/rest/addrole/").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/rest/addrole/deleterole/{roleid}").hasAuthority("ADMIN")
				
				.antMatchers(HttpMethod.POST, "/rest/assignRole/assignrole").hasAuthority("ADMIN")
				
				
				
				.antMatchers(HttpMethod.PUT, "/rest/users").permitAll()
				.antMatchers(HttpMethod.POST, "/rest/Users").permitAll()

				.antMatchers(HttpMethod.POST, "/rest/login/*").permitAll()
				.antMatchers(HttpMethod.POST,"/rest/assignRole/**").permitAll()
				.antMatchers(HttpMethod.POST,"/rest/addrole/**").permitAll()
				.antMatchers(HttpMethod.GET, "/rest/Users/getalluser").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/rest/Category/getallcategory").hasAuthority("USER")
				// all other requests need to be authenticated
				.anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	// To allow Pre-flight [OPTIONS] request from browser
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
}