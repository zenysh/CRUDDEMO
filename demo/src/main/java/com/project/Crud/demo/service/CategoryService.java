package com.project.Crud.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.exception.AlreadyExistException;
import com.project.Crud.demo.exception.NotFoundException;
import com.project.Crud.demo.model.Category;
import com.project.Crud.demo.repository.CategoryRespository;
import com.project.Crud.demo.request.CategoryCreation;
import com.project.Crud.demo.response.CategoryResponse;

@Service
public class CategoryService {

	@Autowired
	CategoryRespository categoryrepo;

	//private Optional<Category> getCategoryWithId(Long id) {
	//	Optional<Category> cat = categoryrepo.findById(id);
	//	if (!cat.isPresent()) {
	//		throw new NotFoundException("No user found");
	//	}
	//	return cat;
	//}

	@Transactional
	public String CreateCategory(CategoryCreation CC) {
		Category category = categoryrepo.findByName(CC.getName());
		if (category != null) {
			throw new AlreadyExistException(CC.getName() + "already exists");
		}
		try {
			Category cat = new Category();
			cat.setName(CC.getName());
			cat.setPicture(CC.getPicture());
			categoryrepo.save(cat);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "category created";
	}

	@Transactional
	public Optional<Category> deletecategory(Long categoryid) {
		Optional<Category> category = categoryrepo.findById(categoryid);
		if (!category.isPresent()) {
			throw new NotFoundException("No Category found");
		}
		try {
			categoryrepo.deleteById(categoryid);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return Optional.empty();
	}

	@Transactional
	public String updateCategory(String name, CategoryCreation categorycreation) {
		Category category = categoryrepo.findByName(name);
		if (category == null) {
			throw new NotFoundException("No Category found to update");
		}
		try {
			category.setName(categorycreation.getName());
			category.setPicture(categorycreation.getPicture());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		categoryrepo.save(category);
		return "Category updated";
	}

	@Transactional
	public List<CategoryResponse> getallCategory() {
		List<CategoryResponse> catRes = new ArrayList<CategoryResponse>();
		List<Category> categoryList = categoryrepo.findAll();
		categoryList.stream().forEach(u -> {
			CategoryResponse cRes = new CategoryResponse();
			cRes.setName(u.getName());
			cRes.setPicture(u.getPicture());
			catRes.add(cRes);
		});
		return catRes;
	}

}
