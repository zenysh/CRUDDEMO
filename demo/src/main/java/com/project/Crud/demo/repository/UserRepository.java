package com.project.Crud.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Crud.demo.model.Users;

public interface UserRepository  extends JpaRepository<Users, Long>{

	Users findByfrstname(String firsname);
   // Users findByUserId(Long id);
}
