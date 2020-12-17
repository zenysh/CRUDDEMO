package com.project.Crud.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	/** The picture. */
	@Column(name = "picture")
	private String picture;

	/** The products. */
//	@OneToMany(mappedBy = "category")
	//private List<Product> products;

	public Category() {

	}

	public Category(Long categoryid, String name, String picture, List<Category> children) {
		this.id = categoryid;
		this.name = name;
		this.picture = picture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


}
