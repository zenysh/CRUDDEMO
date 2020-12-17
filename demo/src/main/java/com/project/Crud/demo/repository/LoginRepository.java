package com.project.Crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Crud.demo.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

	Login findByusername(String username);
	//Login findbyloginid(Long loginid);
}
