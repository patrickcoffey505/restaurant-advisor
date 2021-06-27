package com.example.RestaurantAdvisor.domain;

public class Customer {
	
	String email;
	String fName;
	String lName;
	String phone;
	String password;
	String streetNo;
	String streetName;
	String city;
	String state;
	String zip;

	public Customer() {
		this.email = "";
		this.password = "";
	}

	public Customer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Customer(String email, String password, String fName, String lName) {
		super();
		this.email = email;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
	}

	public Customer(String email, String fName, String lName, String phone, String password, String streetNo, String streetName, String city, String state, String zip) {
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.password = password;
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return this.lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreetNo() {
		return this.streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetName() {
		return this.streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setAddress(String streetNo, String streetName, String city, String state, String zip) {
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "{" +
			" email='" + getEmail() + "'" +
			", fName='" + getFName() + "'" +
			", lName='" + getLName() + "'" +
			", phone='" + getPhone() + "'" +
			", password='" + getPassword() + "'" +
			", streetNo='" + getStreetNo() + "'" +
			", streetName='" + getStreetName() + "'" +
			", city='" + getCity() + "'" +
			", state='" + getState() + "'" +
			", zip='" + getZip() + "'" +
			"}";
	}


}
