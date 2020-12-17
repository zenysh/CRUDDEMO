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
import com.project.Crud.demo.request.UserCreation;
import com.project.Crud.demo.response.UserResponse;
import com.project.Crud.demo.service.UserService;

@RestController
@RequestMapping("rest/Users")
public class UserController {

	@Autowired
	private UserService userservice;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestHeader Long userId, @RequestBody UserCreation userCreation) {
		String user = userservice.CreateUser(userId, userCreation);
		return new ResponseEntity<Object>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "deleteuser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@RequestHeader Long userId, @PathVariable Long id) {
		userservice.deleteUser(userId);
		return new ResponseEntity<Object>("Successfully Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/getalluser",method = RequestMethod.GET)
	public ResponseEntity<Object> getUser() {
		List<UserResponse> response = userservice.getAllUsers();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/edituser/{userId}",method = RequestMethod.PUT)
	public ResponseEntity<Object> editUser(@RequestHeader Long userId, @RequestBody UserCreation usercreation) {
		userservice.updateUser(userId, usercreation);
		return new ResponseEntity<Object>("Successfully Edited", HttpStatus.OK);
	}

}