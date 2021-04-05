package com.cs.SpringSecurityWithJWT.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TAB")
public class User {
	
	@Id
	private Integer id;
	private String userName;
	private String password;
	private String mail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public User(Integer id, String userName, String password, String mail) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mail = mail;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
