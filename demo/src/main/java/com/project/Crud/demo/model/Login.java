package com.project.Crud.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loginid;

	private String username;

	private String password;

	public Login() {

	}

	public Long getloginid() {
		return loginid;
	}

	public void setloginid(Long loginid) {
		this.loginid = loginid;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * @OneToOne(mappedBy = "login") private User user;
	 */

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
