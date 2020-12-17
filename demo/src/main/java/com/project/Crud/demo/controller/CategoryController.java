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
import org.springframework.web.bind.annotation.RestController;
import com.project.Crud.demo.request.CategoryCreation;
import com.project.Crud.demo.response.CategoryResponse;
import com.project.Crud.demo.service.CategoryService;

@RestController
@RequestMapping("rest/controller")
public class CategoryController {

	@Autowired
	private CategoryService categoryservice;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestHeader Long userId, @RequestBody CategoryCreation userCreation) {
		String category = categoryservice.CreateCategory(userCreation);
		return new ResponseEntity<Object>(category, HttpStatus.CREATED);
	}

	@RequestMapping(value = "deletecategory/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@RequestHeader Long userId, @PathVariable Long categoryid) {
		categoryservice.deleteCategory(categoryid);
		return new ResponseEntity<Object>("Successfully Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/getallcategory", method = RequestMethod.GET)
	public ResponseEntity<Object> getUser() {
		List<CategoryResponse> response = categoryservice.getallCategory();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/editCategory/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> editUser(@RequestHeader Long categoryid, @RequestBody CategoryCreation userCreation) {
		categoryservice.updateCategory(categoryid, userCreation);
		return new ResponseEntity<Object>("Successfully Edited", HttpStatus.OK);
	}

}
