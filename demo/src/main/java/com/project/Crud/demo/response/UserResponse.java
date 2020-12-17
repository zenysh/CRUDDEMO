package com.project.Crud.demo.response;

public class UserResponse {

	private Long id;

	private String frstname;

	private String lstname;

	private String email;

	private String address;

	private String contact;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrstname() {
		return frstname;
	}

	public void setFrstname(String frstname) {
		this.frstname = frstname;
	}

	public String getLstname() {
		return lstname;
	}

	public void setLstname(String lstname) {
		this.lstname = lstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
