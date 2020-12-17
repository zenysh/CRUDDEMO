package com.project.Crud.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.exception.AlreadyExistException;
import com.project.Crud.demo.exception.NotFoundException;
import com.project.Crud.demo.model.Product;
import com.project.Crud.demo.repository.ProductRepository;
import com.project.Crud.demo.response.ProductResponse;
import com.project.Crud.demo.request.ProductCreation;

@Service
public class ProductService {

	@Autowired
	ProductRepository productrepo;

	// private Product getProductWithId(Long id) {
//		Product product = productrepo.findByProductid(id);
	// if (product == null)
	// throw new NotFoundException("No user found");
	// return product;
//	}

	@Transactional
	public String CreateProduct(ProductCreation productcreation) {
		Product product = productrepo.findByname(productcreation.getName());
		if (product != null) {
			throw new AlreadyExistException(productcreation.getName() + "already exists");
		}
		try {
			Product products = new Product();
			products.setName(productcreation.getName());
			products.setPicture1(productcreation.getPicture1());
			products.setPicture2(productcreation.getPicture2());
			products.setPicture3(productcreation.getPicture3());
			products.setDescription(productcreation.getDescription());
			products.setPrice(productcreation.getPrice());
			productrepo.save(products);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Product Created";
	}

	@Transactional
	public String deleteProduct(Long productid) {
		Optional<Product> product = productrepo.findById(productid);
		if (product.isEmpty()) {
			throw new NotFoundException("Product not Found to delete");
		}
		try {
			productrepo.deleteById(productid);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Product deleted";

	}

	@Transactional
	public String updateProduct(String productname, ProductCreation productcreation) {
		Product product = productrepo.findByname(productname);
		if (product == null) {
			throw new NotFoundException("No Product found to update");
		}
		try {
			product.setName(productcreation.getName());
			product.setPicture1(productcreation.getPicture1());
			product.setPicture2(productcreation.getPicture2());
			product.setPicture3(productcreation.getPicture3());
			product.setDescription(productcreation.getDescription());
			product.setPrice(productcreation.getPrice());

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		productrepo.save(product);
		return "Product updated";

	}

	@Transactional
	public List<ProductResponse> getAllproduct() {
		List<ProductResponse> prores = new ArrayList<ProductResponse>();
		List<Product> productlist = productrepo.findAll();
		productlist.stream().forEach(u -> {
			ProductResponse pr = new ProductResponse();
			pr.setName(u.getName());
			pr.setPicture1(u.getPicture1());
			pr.setPicture2(u.getPicture2());
			pr.setPicture3(u.getPicture3());
			pr.setDescription(u.getDescription());
			pr.setPrice(u.getPrice());
			pr.setProductid(u.getid());
			prores.add(pr);
		});
		return prores;

	}
}
