package com.project.Crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Crud.demo.request.ProductCreation;
import com.project.Crud.demo.response.ProductResponse;
import com.project.Crud.demo.service.Popular_itemsService;
import com.project.Crud.demo.service.ProductService;

@RestController
@RequestMapping("rest/product")
public class ProductController {

	@Autowired
	private ProductService productservice;

	@Autowired
	Popular_itemsService popularService;

	@RequestMapping(value = "createProduct", method = RequestMethod.POST)
	public ResponseEntity<Object> CreateProduct(@RequestParam(required = false, value = "key") String CategoryName,
			@RequestBody ProductCreation productcreation) {
		String product = productservice.CreateProduct(CategoryName, productcreation);
		return new ResponseEntity<Object>(product, HttpStatus.CREATED);
	}

	@RequestMapping(value = "deleteproduct/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long productid) {
		productservice.deleteProduct(productid);
		return new ResponseEntity<Object>("Successfully Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllproduct", method = RequestMethod.GET)
	public ResponseEntity<Object> getallproduct() {
		List<ProductResponse> response = productservice.getAllproduct();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getProductByid/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getproductbyid(@PathVariable(value = "id") Long productid) {
		// should be added at get one product
		// counter++ into database maybe
		List<ProductResponse> response = productservice.getproductbyid(productid);
		popularService.AddPopularitems(productid);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	@RequestMapping(value = "/getProductByid/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getprodusctbyid(@PathVariable(value = "id") Long productid) {
		// should be added at get one product
		// counter++ into database maybe
		List<ProductResponse> response = productservice.getproductbyid(productid);
		popularService.AddPopularitems(productid);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	//lkl

	@RequestMapping(value = "/editproduct", method = RequestMethod.PUT)
	public ResponseEntity<Object> editUser(@RequestHeader String Firstname,
			@RequestBody ProductCreation productcreation) {
		productservice.updateProduct(Firstname, productcreation);
		return new ResponseEntity<Object>("Successfully Edited", HttpStatus.OK);
	}

}
