package com.project.Crud.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Crud.demo.model.Featured_items;
import com.project.Crud.demo.repository.FeaturedCategory;
import com.project.Crud.demo.request.FeatureCreation;
import com.project.Crud.demo.response.Featureresponse;

@Service
public class FeatureService {

	@Autowired
	FeaturedCategory ferepo;

	@Transactional
	public String CreateFeature(FeatureCreation featurecre) {
		try {
			Featured_items fi = new Featured_items();
		//	fi.setCategoryname(featurecre.getCategoryname());
			fi.setProductid(featurecre.getProductid());
			ferepo.save(fi);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Featured item added";

	}

	@Transactional
	public List<Featureresponse> getAllFeaturedItems() {
		List<Featureresponse> Fres = new ArrayList<Featureresponse>();
		List<Featured_items> Fitems = ferepo.findAll();
		Fitems.stream().forEach(u -> {
			Featureresponse res = new Featureresponse();
		//	res.setCategoryname(u.getCategoryname());
			res.setProductid(u.getProductid());
			Fres.add(res);
		});
		return Fres;
	}

}
