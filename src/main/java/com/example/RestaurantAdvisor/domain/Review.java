package com.example.RestaurantAdvisor.domain;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// @Entity
public class Review {
	
	private static final AtomicInteger count = new AtomicInteger(0); 

	// @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int reviewID;

	String custEmail;
	String restID;
	String reviewTitle;
	String reviewDescr;
	String reviewDate;
	String rating;


	public Review() {
	}

	public Review(String custEmail, String restID, String reviewTitle, String reviewDescr, String rating) {
		
		this.reviewID = count.incrementAndGet(); 
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
		this.reviewDate = java.time.LocalDateTime.now().format(formatter);

		this.custEmail = custEmail;
		this.restID = restID;
		this.reviewTitle = reviewTitle;
		this.reviewDescr = reviewDescr;
		this.rating = rating;
	}

	public int getReviewID() {
		return this.reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getRestID() {
		return this.restID;
	}

	public void setRestID(String restID) {
		this.restID = restID;
	}

	public String getReviewTitle() {
		return this.reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewDescr() {
		return this.reviewDescr;
	}

	public void setReviewDescr(String reviewDescr) {
		this.reviewDescr = reviewDescr;
	}

	public String getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "{" +
			" reviewID='" + getReviewID() + "'" +
			", custEmail='" + getCustEmail() + "'" +
			", restID='" + getRestID() + "'" +
			", reviewTitle='" + getReviewTitle() + "'" +
			", reviewDescr='" + getReviewDescr() + "'" +
			", reviewDate='" + getReviewDate() + "'" +
			", rating='" + getRating() + "'" +
			"}";
	}
	

}
