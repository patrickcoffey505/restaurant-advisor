package com.example.RestaurantAdvisor.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.RestaurantAdvisor.domain.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantDAO {

	@Autowired
	private RestaurantDatabaseMapper restMapper;
	
	public List<Restaurant> getRestaurants() {
		List<Restaurant> restList = new ArrayList<Restaurant>();
		
		restList = restMapper.getRestaurants();
		return restList;
	}
}
