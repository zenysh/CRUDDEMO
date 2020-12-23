package com.project.Crud.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.exception.AlreadyExistException;
import com.project.Crud.demo.exception.NotFoundException;
import com.project.Crud.demo.model.Category;
import com.project.Crud.demo.model.Product;
import com.project.Crud.demo.repository.CategoryRespository;
import com.project.Crud.demo.repository.ProductRepository;
import com.project.Crud.demo.response.ProductResponse;
import com.project.Crud.demo.request.ProductCreation;

@Service
public class ProductService {

	@Autowired
	ProductRepository productrepo;

	@Autowired
	CategoryRespository categoryrepo;

	// private Product getProductWithId(Long id) {
//		Product product = productrepo.findByProductid(id);
	// if (product == null)
	// throw new NotFoundException("No user found");
	// return product;
//	}

	@Transactional
	public String CreateProduct(String Category, ProductCreation productcreation) {
		Product product = productrepo.findByname(productcreation.getName());
		Category cat = categoryrepo.findByName(Category);
		if (product != null) {
			throw new AlreadyExistException(productcreation.getName() + "already exists");
		}
		try {

			System.out.print(cat.getName());
			Product products = new Product();
			products.setName(productcreation.getName());
			products.setPicture1(productcreation.getPicture1());
			products.setPicture2(productcreation.getPicture2());
			products.setPicture3(productcreation.getPicture3());
			products.setDescription(productcreation.getDescription());
			products.setPrice(productcreation.getPrice());
			products.setDateadded(new Date());
			products.setCategory(cat);
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
			pr.setCategoryid(u.getCategory().getId());
			pr.setName(u.getName());
			pr.setPicture1(u.getPicture1());
			pr.setPicture2(u.getPicture2());
			pr.setPicture3(u.getPicture3());
			pr.setDescription(u.getDescription());
			pr.setPrice(u.getPrice());
			pr.setProductid(u.getid());
			pr.setDateAdded(u.getDateadded());
			prores.add(pr);
		});
		return prores;

	}

	@Transactional
	public List<ProductResponse> getproductbyid(Long productid) {
		List<ProductResponse> prores = new ArrayList<ProductResponse>();
		Optional<Product> productlist = productrepo.findById(productid);
		productlist.stream().forEach(u -> {
			ProductResponse pr = new ProductResponse();
			pr.setCategoryid(u.getCategory().getId());
			pr.setProductid(u.getId());
			pr.setName(u.getName());
			pr.setDescription(u.getDescription());
			pr.setDateAdded(u.getDateadded());
			pr.setPicture1(u.getPicture1());
			pr.setPicture2(u.getPicture2());
			pr.setPicture3(u.getPicture3());
			pr.setPrice(u.getPrice());
			prores.add(pr);
		});
		return prores;
	}

	@Transactional
	public List<ProductResponse> getbyproductname(String productname) {
		List<ProductResponse> prores = new ArrayList<ProductResponse>();
		Product productlist = productrepo.findByname(productname);
		if (productlist == null) {
			throw new NotFoundException("Product you are searching  " + productname + " is not found");
		} else {
			ProductResponse pr = new ProductResponse();
			pr.setCategoryid(productlist.getCategory().getId());
			pr.setProductid(productlist.getId());
			pr.setName(productlist.getName());
			pr.setDescription(productlist.getDescription());
			pr.setDateAdded(productlist.getDateadded());
			pr.setPicture1(productlist.getPicture1());
			pr.setPicture2(productlist.getPicture2());
			pr.setPicture3(productlist.getPicture3());
			pr.setPrice(productlist.getPrice());
			prores.add(pr);
		}
		return prores;
	}
}
