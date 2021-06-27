package com.example.RestaurantAdvisor.service;
import java.util.List;

import com.example.RestaurantAdvisor.dao.RestaurantDAO;
import com.example.RestaurantAdvisor.domain.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RestaurantService {

@Autowired
RestaurantDAO restDAO;
	
	public List<Restaurant> getRestaurants() {
		return restDAO.getRestaurants();
	}

}	


