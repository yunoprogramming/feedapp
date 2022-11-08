package com.bptn.bean;

public class UserID {

	String username;

	String name;

	String email;
	
	String phoneNumber;
	
	String userPassword;
	
	public UserID() {
		super();
	}

	public UserID(String username) {
		super();
        this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserID [username=" + username + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", userPassword=" + userPassword + "]";
	}	
}