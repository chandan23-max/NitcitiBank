package com.cs.SpringSecurityWithJWT.entity;

public class RequestAuth {
	
	private String userName;
	private String password;
	public RequestAuth(String userName, String password) {
		this.userName = userName;
		this.password = password;
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
	
	
	public RequestAuth() {
		// TODO Auto-generated constructor stub
	}

}
