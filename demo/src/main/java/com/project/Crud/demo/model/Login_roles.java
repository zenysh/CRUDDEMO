package com.project.Crud.demo.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Login_roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String role;

	private String username;

	public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public Login_roles() {

	}
	// private Long loginid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




}
