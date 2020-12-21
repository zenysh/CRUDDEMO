package com.project.Crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.Crud.demo.response.FeatureItemResponse;
import com.project.Crud.demo.service.FeatureItemReturnService;

@RestController
@RequestMapping("rest/Feature")
public class FeaturedController {

	@Autowired
	private FeatureItemReturnService FtRService;
	
//(required = false, value = "key")
//(required = false, value = "key")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> Featureitem(@RequestParam String Productname,
			@RequestParam String CategoryName) {
		String Feature = FtRService.AddFeaturedItems(Productname, CategoryName);
		return new ResponseEntity<Object>(Feature, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getfeatured", method = RequestMethod.GET)
	public ResponseEntity<Object> getFeatured() {
		List<FeatureItemResponse> response = FtRService.getAllFeatureditems();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
