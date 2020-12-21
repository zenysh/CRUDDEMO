package com.project.Crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Crud.demo.response.PopularitemsReponse;
import com.project.Crud.demo.service.Popular_itemsService;

@RestController
@RequestMapping("rest/popular")
public class PopularController {

	@Autowired
	Popular_itemsService popularitem;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getpopularitems(/* parameter for category */) {
		List<PopularitemsReponse> pr = popularitem.getPopularitems();
		return new ResponseEntity<Object>(pr, HttpStatus.OK);

	}
}
