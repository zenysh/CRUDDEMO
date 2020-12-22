package com.project.Crud.demo.configuration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.model.Login;
import com.project.Crud.demo.repository.LoginRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	LoginRepository loginrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// here we can use user repository to extract username and password

		/*
		 * Login login = loginrepo.findByusername(username); if
		 * (login.getUsername().equals(username)) { return new Login(); } else { throw
		 * new UsernameNotFoundException("User not found with username: " + username); }
		 */

		if ("javainuse".equals(username)) {
			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}