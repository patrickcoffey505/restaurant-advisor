package com.example.RestaurantAdvisor.domain;

public class Restaurant {
	
	String restID;
	String rName;
	String phone;
	String email;
	String hours;
	String diningType;
	String streetNo;
	String streetName;
	String city;
	String state;
	String zip;
	String priceRange;
	String deliveryFlag;
	String outdoorSeatingFlag;


	public Restaurant() {
		this.restID = "";
		this.rName = "";
	}

	public Restaurant(String restID, String rName) {
		this.restID = restID;
		this.rName = rName;
	}	

	public Restaurant(String restID, String rName, String phone, String email, String hours, String diningType, String streetNo, String streetName, String city, String state, String zip, String priceRange, String deliveryFlag, String outdoorSeatingFlag) {
		this.restID = restID;
		this.rName = rName;
		this.phone = phone;
		this.email = email;
		this.hours = hours;
		this.diningType = diningType;
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.priceRange = priceRange;
		this.deliveryFlag = deliveryFlag;
		this.outdoorSeatingFlag = outdoorSeatingFlag;
	}

	public String getRestID() {
		return this.restID;
	}

	public void setRestID(String restID) {
		this.restID = restID;
	}

	public String getRName() {
		return this.rName;
	}

	public void setRName(String rName) {
		this.rName = rName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHours() {
		return this.hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getDiningType() {
		return this.diningType;
	}

	public void setDiningType(String diningType) {
		this.diningType = diningType;
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

	public String getPriceRange() {
		return this.priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public String getDeliveryFlag() {
		return this.deliveryFlag;
	}

	public void setDeliveryFlag(String deliveryFlag) {
		this.deliveryFlag = deliveryFlag;
	}

	public String getOutdoorSeatingFlag() {
		return this.outdoorSeatingFlag;
	}

	public void setOutdoorSeatingFlag(String outdoorSeatingFlag) {
		this.outdoorSeatingFlag = outdoorSeatingFlag;
	}

	@Override
	public String toString() {
		return "{" +
			" restID='" + getRestID() + "'" +
			", rName='" + getRName() + "'" +
			", phone='" + getPhone() + "'" +
			", email='" + getEmail() + "'" +
			", hours='" + getHours() + "'" +
			", diningType='" + getDiningType() + "'" +
			", streetNo='" + getStreetNo() + "'" +
			", streetName='" + getStreetName() + "'" +
			", city='" + getCity() + "'" +
			", state='" + getState() + "'" +
			", zip='" + getZip() + "'" +
			", priceRange='" + getPriceRange() + "'" +
			", deliveryFlag='" + getDeliveryFlag() + "'" +
			", outdoorSeatingFlag='" + getOutdoorSeatingFlag() + "'" +
			"}";
	}
}