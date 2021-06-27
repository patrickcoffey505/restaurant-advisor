package com.example.RestaurantAdvisor.domain;

public class Menu {
	
	String foodName;
	String price;

	public Menu() {
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "{" +
			" foodName='" + getFoodName() + "'" +
			", price='" + getPrice() + "'" +
			"}";
	}	

}
