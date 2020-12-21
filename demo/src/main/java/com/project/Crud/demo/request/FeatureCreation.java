package com.project.Crud.demo.request;

import java.util.Date;


public class FeatureCreation {
	private String CategoryName;

	private String name;

	private String description;

	private Date dateadded;

	private String picture1;

	private String picture2;

	private String picture3;

	public String getCategoryname() {
		return Categoryname;
	}

	public void setCategoryname(String categoryname) {
		Categoryname = categoryname;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Long getCategoryid() {
		return Categoryid;
	}

	public void setCategoryid(Long categoryid) {
		Categoryid = categoryid;
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

	private String Categoryname;

	private Long productid;

	private Long Categoryid;

}
