package com.project.Crud.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.model.Category;
import com.project.Crud.demo.model.Featured_items;
import com.project.Crud.demo.model.Product;
import com.project.Crud.demo.repository.CategoryRespository;
import com.project.Crud.demo.repository.FeaturedCategory;
import com.project.Crud.demo.repository.ProductRepository;
import com.project.Crud.demo.request.FeatureCreation;
import com.project.Crud.demo.response.FeatureItemResponse;

@Service
public class FeatureItemReturnService {

	@Autowired
	FeaturedCategory featurecategory;

	@Autowired
	ProductRepository prorepo;

	@Autowired
	CategoryRespository catrepo;

	@Transactional
	public String AddFeaturedItems(String productname, String Categoryname) {
		try {
			Product pro = prorepo.findByname(productname);
			Category cat = catrepo.findByName(Categoryname);
			Featured_items ft = new Featured_items();
			ft.setCategoryid(cat.getId());
			ft.setProductid(pro.getid());
			ft.setName(pro.getName());
			ft.setCategoryName(cat.getName());
			ft.setDateadded(pro.getDateadded());
			ft.setDescription(pro.getDescription());
			ft.setPicture1(pro.getPicture1());
			ft.setPicture2(pro.getPicture2());
			ft.setPicture3(pro.getPicture3());
			featurecategory.save(ft);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Featured added";

	}

	@Transactional
	public List<FeatureItemResponse> getAllFeatureditems() {
		List<FeatureItemResponse> fit = new ArrayList<FeatureItemResponse>();
		List<Featured_items> fi = featurecategory.findAll();
		fi.stream().forEach(u -> {
			FeatureItemResponse fits = new FeatureItemResponse();
			fits.setProductid(u.getProductid());
			fits.setProductname(u.getName());
			fits.setDesc(u.getDescription());
			fits.setCategoryname(u.getCategoryName());
			fits.setPic1(u.getPicture1());
			fits.setPic2(u.getPicture2());
			fits.setPic3(u.getPicture3());
			fit.add(fits);
		});
		return fit;

	}

}
