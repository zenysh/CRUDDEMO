package com.project.Crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Crud.demo.model.Featured_items;

public interface FeaturedCategory extends JpaRepository<Featured_items, Long>{
	

}
