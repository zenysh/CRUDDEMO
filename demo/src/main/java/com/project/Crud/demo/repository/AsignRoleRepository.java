package com.project.Crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Crud.demo.model.Login_roles;

public interface AsignRoleRepository extends JpaRepository<Login_roles,Long>{
	
}
