package com.example.RestaurantAdvisor.service;

import java.util.List;

import com.example.RestaurantAdvisor.dao.ReviewDAO;
import com.example.RestaurantAdvisor.domain.Customer;
import com.example.RestaurantAdvisor.domain.Restaurant;
import com.example.RestaurantAdvisor.domain.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ReviewService {

@Autowired
ReviewDAO reviewDAO;

	public void addReview(Review review) {
		reviewDAO.addReview(review);
	}	

	public List<Review> getReviewsRest(Restaurant restaurant) {
		return reviewDAO.getReviewsRest(restaurant);
	}

	public List<Review> getReviewsCust(Customer customer) {
		return reviewDAO.getReviewsCust(customer);
	}
}	


