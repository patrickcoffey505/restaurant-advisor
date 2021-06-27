package com.example.RestaurantAdvisor.domain;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// @Entity
public class Order {

	private static final AtomicInteger count = new AtomicInteger(0); 
 	
	// @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int ono;

	String orderDate;
	String custEmail;
	char dineIn;
	char delivery;
	char pickUp;
	String restID;

	public Order() {
	}

	public Order(String email) {

		this.ono = count.incrementAndGet(); 

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
		this.orderDate = java.time.LocalDateTime.now().format(formatter);
		this.custEmail = email;

		this.dineIn = 'N';
		this.delivery = 'N';
		this.pickUp = 'N';
	}

	public Order(int ono, String orderDate, String custEmail, char dineIn, char delivery, char pickUp) {
		this.ono = ono;
		this.orderDate = orderDate;
		this.custEmail = custEmail;
		this.dineIn = dineIn;
		this.delivery = delivery;
		this.pickUp = pickUp;
	}

	public void setType(String type) {
		if (type.equals("Dine In")) { this.dineIn = 'Y'; }
		if (type.equals("Delivery")) { this.delivery = 'Y'; }
		if (type.equals("Pick Up")) { this.pickUp = 'Y'; }
	}

	public int getOno() {
		return this.ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}

	public String getRestID() {
		return this.restID;
	}

	public void setRestID(String restID) {
		this.restID = restID;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public char getDineIn() {
		return this.dineIn;
	}

	public void setDineIn(char dineIn) {
		this.dineIn = dineIn;
	}

	public char getDelivery() {
		return this.delivery;
	}

	public void setDelivery(char delivery) {
		this.delivery = delivery;
	}

	public char getPickUp() {
		return this.pickUp;
	}

	public void setPickUp(char pickUp) {
		this.pickUp = pickUp;
	}

	@Override
	public String toString() {
		return "{" +
			" ono='" + getOno() + "'" +
			", orderDate='" + getOrderDate() + "'" +
			", custEmail='" + getCustEmail() + "'" +
			", dineIn='" + getDineIn() + "'" +
			", delivery='" + getDelivery() + "'" +
			", pickUp='" + getPickUp() + "'" +
			"}";
	}

}
