package com.project.Crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.project.Crud.demo.request.LoginCreation;
import com.project.Crud.demo.response.LoginResponse;
import com.project.Crud.demo.service.LoginService;

@RestController
@RequestMapping("rest/login")
public class LoginController {

	@Autowired
	private LoginService loginservice;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> CreateLogin(@RequestHeader Long productid, @RequestBody LoginCreation logincreation) {
		String login = loginservice.CreateUser(logincreation);
		return new ResponseEntity<Object>(login, HttpStatus.CREATED);
	}

	@RequestMapping(value = "deletelogin/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteLogin(@PathVariable Long loginid) {
		loginservice.deleteLogin(loginid);
		return new ResponseEntity<Object>("Successfully Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllproductLogin", method = RequestMethod.GET)
	public ResponseEntity<Object> getUser() {
		List<LoginResponse> response = loginservice.getAllLogin();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/editLogin/{loginid}", method = RequestMethod.PUT)
	public ResponseEntity<Object> editUser(@RequestHeader Long loginid, @RequestBody LoginCreation Logincreation) {
		loginservice.updateLogin(loginid, Logincreation);
		return new ResponseEntity<Object>("Successfully Edited", HttpStatus.OK);
	}

}
