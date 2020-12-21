package com.project.Crud.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Popular_items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hitid", unique = true, nullable = false)
	private Long hitid;

	private Long prodictid;

	private int hits;

	public Long getHitid() {
		return hitid;
	}

	public void setHitid(Long hitid) {
		this.hitid = hitid;
	}

	public Long getProdictid() {
		return prodictid;
	}

	public void setProdictid(Long prodictid) {
		this.prodictid = prodictid;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

}
