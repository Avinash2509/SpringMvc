package com.mvc.modal;

public class Usermodel {

	private Integer id;
	private String username;
	private String contact;
	private String email;
	private String password;
	private String gender;
	private String address;
	
	public Usermodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usermodel(Integer id, String username, String contact, String email, String password, String gender,
			String address) {
		super();
		this.id = id;
		this.username = username;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
