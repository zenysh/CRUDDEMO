
package com.project.Crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Crud.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	//Product findByProductid(Long id);

	Product findByname(String name);
}
