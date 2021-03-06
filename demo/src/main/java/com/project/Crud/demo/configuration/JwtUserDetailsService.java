package com.project.Crud.demo.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.model.Login;
import com.project.Crud.demo.model.Login_roles;
import com.project.Crud.demo.repository.LoginRepository;
import com.project.Crud.demo.repository.LoginRolesRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	LoginRepository loginrepo;
	
	@Autowired
	LoginRolesRepository loginrole;
	
	// for more than 1 authorities private List<GrantedAuthority> authorities;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// here we can use user repository to extract username and password
		if (loginrepo.findByusername(username).getUsername().equals(username)) {
			GrantedAuthority authority = new SimpleGrantedAuthority(loginrole.findByusername(username).getRole());
			/*
			 * [For more than 1 authorities ]   authorities =  Arrays.stream(loginrolerepo.findByusername(username).getRole().split(","))
			 * .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
			 */
			System.out.println("authority" + authority);
			return new User(loginrepo.findByusername(username).getUsername(),
					loginrepo.findByusername(username).getPassword(),Arrays.asList(authority));
			// return new User("javainuse",
			// "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
			// new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}