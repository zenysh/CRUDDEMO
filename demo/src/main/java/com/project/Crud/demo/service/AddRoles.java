package com.project.Crud.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.model.Roles;
import com.project.Crud.demo.repository.AddRolesRepository;
import com.project.Crud.demo.request.RoleCreation;

@Service
public class AddRoles {

	@Autowired
	AddRolesRepository addrolesrepo;
	
	@Transactional
	public String addRole(RoleCreation roleCr) {
		try {
			Roles role = new Roles();
			role.setRole(roleCr.getRole_name());
			addrolesrepo.save(role);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Role Added";
	}
	
	@Transactional
	public String deleteRole(Long roleid) {
		try {
			addrolesrepo.deleteById(roleid);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Role deleted";
	}
}
