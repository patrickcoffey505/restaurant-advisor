package com.example.RestaurantAdvisor.dao;


import java.util.List;

import com.example.RestaurantAdvisor.domain.Customer;
import com.example.RestaurantAdvisor.domain.Restaurant;
import com.example.RestaurantAdvisor.domain.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewDAO {

	@Autowired
	private RestaurantDatabaseMapper restMapper;
	
	public void addReview(Review review) {
		restMapper.addReview(review);
	}

	public List<Review> getReviewsRest(Restaurant restaurant) {
		return restMapper.getReviewsRest(restaurant);
	}

	public List<Review> getReviewsCust(Customer customer) {
		return restMapper.getReviewsCust(customer);
	}
}
