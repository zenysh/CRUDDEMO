package com.project.Crud.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Crud.demo.model.Popular_items;
import com.project.Crud.demo.repository.Popular_itemsRepository;
import com.project.Crud.demo.response.PopularitemsReponse;

@Service
public class Popular_itemsService {

	@Autowired
	Popular_itemsRepository piRepo;

	@Transactional
	public String AddPopularitems(Long productid) {
		try {
			int hit = 1;
			Popular_items pi = new Popular_items();
			Optional<Popular_items> productItems = piRepo.findById(productid);
			productItems.stream().forEach(i -> {
				pi.setProdictid(productid);
				pi.setHits(1);
				piRepo.save(pi);
			});

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "Popular items Added";
	}

	@Transactional
	public List<PopularitemsReponse> getPopularitems() {
		List<PopularitemsReponse> Pir = new ArrayList<PopularitemsReponse>();
		List<Popular_items> poitems = piRepo.findAll();
		poitems.stream().forEach(u -> {
			PopularitemsReponse PIrt = new PopularitemsReponse();
			PIrt.setProdictid(u.getProdictid());
			PIrt.setHits(u.getHits());
			Pir.add(PIrt);
		});
		return Pir;
	}

}
