package com.example.springBoot.domain;


public class Customer {
	
	private static int count = 0; 
	
	public static int getCount() {
		return count;
	}

	private String id; 
	private String firstname;
	private String lastname;
	private String mail;
	private String  mobileNo;
	private String address;
	
	public Customer(){}
	
	public Customer(String id, String firstname, String lastname, String mail, String mobileNo, String address) {
		this.id =  id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}