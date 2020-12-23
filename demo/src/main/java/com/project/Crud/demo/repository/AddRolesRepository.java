package com.project.Crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Crud.demo.model.Roles;

public interface AddRolesRepository extends JpaRepository<Roles,Long>{
	Roles findByrole(String role);	

}
