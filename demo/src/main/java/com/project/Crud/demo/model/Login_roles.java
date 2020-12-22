package com.project.Crud.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Login_roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String rolename;

	private String username;

	public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
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
