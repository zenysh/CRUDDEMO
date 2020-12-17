package com.project.Crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Crud.demo.model.Category;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Long> {

	Category findByName(String name);

	//Category findBycategoryid(Long categoryid);
}
