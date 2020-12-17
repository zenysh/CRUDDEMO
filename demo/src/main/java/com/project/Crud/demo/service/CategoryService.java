package com.project.Crud.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.Crud.demo.exception.AlreadyExistException;
import com.project.Crud.demo.exception.NotFoundException;
import com.project.Crud.demo.model.Category;
import com.project.Crud.demo.repository.CategoryRespository;
import com.project.Crud.demo.request.CategoryCreation;
import com.project.Crud.demo.response.CategoryResponse;

public class CategoryService {

	@Autowired
	CategoryRespository categoryrepo;

	private Category getCategoryWithId(Long id) {
		Category cat = categoryrepo.findByCategoryId(id);
		if (cat == null)
			throw new NotFoundException("No user found");
		return cat;
	}

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
	public String deleteCategory(Long categoryid) {
		Category category = categoryrepo.findByCategoryId(categoryid);
		if (category == null) {
			throw new NotFoundException("Category not Found to delete");
		}
		try {
			categoryrepo.delete(category);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Category delete";
	}

	@Transactional
	public String updateCategory(Long categoryid, CategoryCreation categorycreation) {
		Category category = getCategoryWithId(categoryid);
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
