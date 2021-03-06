package com.project.Crud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.model.Login_roles;
import com.project.Crud.demo.repository.AddRolesRepository;
import com.project.Crud.demo.repository.AsignRoleRepository;
import com.project.Crud.demo.repository.LoginRepository;
import com.project.Crud.demo.repository.LoginRolesRepository;

@Service
public class AssignRoleService {

	@Autowired
	LoginRolesRepository loginrolerepo;

	@Autowired
	LoginRepository loginrepo;

	@Autowired
	AddRolesRepository addrolerepo;

	@Autowired
	AsignRoleRepository assignrolerepo;

	public String assignRole(String username, String Role) {
		try {
			// Optional<Login> login = loginrepo.findById(loginid);
			Login_roles lr = new Login_roles();
			lr.setUsername(loginrepo.findByusername(username).getUsername());
			lr.setRole(addrolerepo.findByrole(Role).getRole());
			loginrolerepo.save(lr);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Role Assigned";
	}

}
