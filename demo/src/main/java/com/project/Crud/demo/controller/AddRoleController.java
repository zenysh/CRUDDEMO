package com.project.Crud.demo.controller;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Crud.demo.exception.NotFoundException;
import com.project.Crud.demo.model.Category;
import com.project.Crud.demo.model.Roles;
import com.project.Crud.demo.repository.AddRolesRepository;
import com.project.Crud.demo.request.RoleCreation;
import com.project.Crud.demo.service.AddRoles;

@RestController

@RequestMapping("rest/addrole")
public class AddRoleController {
	
	@Autowired
	AddRoles addroleservice;

	@Autowired
	AddRolesRepository addrolerepo;
	
//	@RolesAllowed("ADMIN")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody RoleCreation RC) {
		String Roles = addroleservice.addRole(RC);
		return new ResponseEntity<Object>(Roles, HttpStatus.CREATED);
	}
	
	@RolesAllowed("ADMIN")
	@RequestMapping(value = "deleterole/{roleid}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "roleid") Long roleid) throws NotFoundException {
		Optional<Roles> category = addrolerepo.findById(roleid);
		if (category.isEmpty()) {
			throw new NotFoundException("id not found");
		} else {
			addroleservice.deleteRole(roleid);
			return new ResponseEntity<Object>("Successfully Deleted", HttpStatus.OK);
		}
	}
}
