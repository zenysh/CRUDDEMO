package com.project.Crud.demo.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.Crud.demo.service.AssignRoleService;

@RestController
@RequestMapping("rest/assignRole")
public class AssignRoleController {

	@Autowired
	AssignRoleService assignroleservice;

	@RolesAllowed("ADMIN")
	@RequestMapping(value = "assignrole",method=RequestMethod.POST)
	public ResponseEntity<Object> AssignRole(@RequestParam (value = "username") String username, @RequestParam(value = "rolename") String rolename) {
	String assignrole = assignroleservice.assignRole(username, rolename);
	return new ResponseEntity<Object>(assignrole, HttpStatus.CREATED);
	
	}

}
