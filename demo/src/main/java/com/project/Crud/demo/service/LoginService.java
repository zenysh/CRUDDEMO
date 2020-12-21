package com.project.Crud.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.exception.AlreadyExistException;
import com.project.Crud.demo.exception.NotFoundException;
import com.project.Crud.demo.model.Login;
import com.project.Crud.demo.repository.LoginRepository;
import com.project.Crud.demo.request.LoginCreation;
import com.project.Crud.demo.response.LoginResponse;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginrepo;

//	private Login getLoginWithId(Long id) {
	// Login login = loginrepo.findbyloginid(id);
	// if (login == null) {
//			throw new NotFoundException("No user found");
	// }
//		return login;
//	}

	@Transactional
	public String CreateLogin(LoginCreation logincreation) {
		Login login = loginrepo.findByusername(logincreation.getUsername());
		if (login != null) {
			throw new AlreadyExistException(logincreation.getUsername() + "already exists");
		}
		try {
			Login newlogin = new Login();
			newlogin.setUsername(logincreation.getUsername());
			newlogin.setPassword(logincreation.getPassword());
			loginrepo.save(newlogin);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "User Created";
	}

	@Transactional
	public String deleteLogin(Long loginid) {
		Optional<Login> login = loginrepo.findById(loginid);
		if (login.isEmpty()) {
			throw new NotFoundException("User not Found to delete");
		}
		try {
			loginrepo.deleteById(loginid);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Login deleted";

	}

	@Transactional
	public String updateLogin(String loginname, LoginCreation logincreation) {
		Login login = loginrepo.findByusername(loginname);
		if(login == null) {
			throw new NotFoundException("No Login found to update");
		}
		try {
			login.setUsername(logincreation.getUsername());
			login.setPassword(logincreation.getPassword());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		loginrepo.save(login);
		return "Login Updated";
	}

	@Transactional
	public List<LoginResponse> getAllLogin() {
		List<LoginResponse> loginres = new ArrayList<LoginResponse>();
		List<Login> loginlist = loginrepo.findAll();
		loginlist.stream().forEach(u -> {
			LoginResponse loginresponse = new LoginResponse();
			loginresponse.setLoginid(u.getLoginid());
			loginresponse.setUsername(u.getUsername());
			loginresponse.setPassword(u.getPassword());
			loginres.add(loginresponse);
		});
		return loginres;
	}
}
