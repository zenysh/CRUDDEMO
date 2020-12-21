package com.project.Crud.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Featured_items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long featureid;

	@Column(name = "Categoryid", nullable = false)
	private Long Categoryid;
	
	@Column(name = "Productid", nullable = false)
	private Long Productid;

	@Column(name = "CategoryName", nullable = false)
	private String CategoryName;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "dateAdded")
	private Date dateadded;

	@Column(name = "picture1")
	private String picture1;

	@Column(name = "picture2")
	private String picture2;

	@Column(name = "picture3")
	private String picture3;

	public Featured_items() {

	}

	public Long getFeatureid() {
		return featureid;
	}

	public void setFeatureid(Long featureid) {
		this.featureid = featureid;
	}

	public Long getCategoryid() {
		return Categoryid;
	}

	public void setCategoryid(Long categoryid2) {
		Categoryid = categoryid2;
	}

	public Long getProductid() {
		return Productid;
	}

	public void setProductid(Long productid) {
		Productid = productid;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateadded() {
		return dateadded;
	}

	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

}
