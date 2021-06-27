package com.example.RestaurantAdvisor.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.RestaurantAdvisor.domain.Restaurant;
import com.example.RestaurantAdvisor.service.RestaurantService;
import com.example.RestaurantAdvisor.service.ReviewService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestaurantController {

	@Autowired
	RestaurantService restService;

	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(value = "/Restaurant/{restID}", method = RequestMethod.GET)
	public String displayRestaurants(@PathVariable String restID, Model model) {

		List<Restaurant> restList = new ArrayList<Restaurant>();
		restList = restService.getRestaurants();

		Restaurant restaurant = new Restaurant();

		for (Restaurant r : restList) {
			if (r.getRestID().equals(restID)) {
				restaurant = r;
			}
		}
		
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("reviews", reviewService.getReviewsRest(restaurant));

		return "displayDetails";
	}
}