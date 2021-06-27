package com.example.RestaurantAdvisor.domain;

public class OrderItem {
	
	int ono;
	String foodName;
	String restID;
	String qty;
	String price;

	public OrderItem() {
	}
	
	public OrderItem(int ono, String foodName, String restID, String qty, String price) {
		this.ono = ono;
		this.foodName = foodName;
		this.restID = restID;
		this.price = price;
		this.qty = qty;
	}

	public OrderItem(String foodName, String price) {
		this.foodName = foodName;
		this.price = price;
		this.qty = "0";
		this.restID = "";
		this.ono = 0;
	}

	public int getOno() {
		return this.ono;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setOno(int ono) {
		this.ono = ono;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getRestID() {
		return this.restID;
	}

	public void setRestID(String restID) {
		this.restID = restID;
	}

	public String getQty() {
		return this.qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "{" +
			" ono='" + getOno() + "'" +
			", foodName='" + getFoodName() + "'" +
			", restID='" + getRestID() + "'" +
			", qty='" + getQty() + "'" +
			"}";
	}

}
