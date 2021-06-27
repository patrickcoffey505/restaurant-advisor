package com.example.RestaurantAdvisor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.RestaurantAdvisor.domain.Customer;
import com.example.RestaurantAdvisor.domain.FormCommand;
import com.example.RestaurantAdvisor.domain.Restaurant;
import com.example.RestaurantAdvisor.service.RestaurantService;
import com.example.RestaurantAdvisor.domain.Review;
import com.example.RestaurantAdvisor.service.ReviewService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReviewController {

	@Autowired
	RestaurantService restService;

	@Autowired
	ReviewService revService;

	@RequestMapping(value = "/Review", method = RequestMethod.GET)
	public String createOrder(@ModelAttribute FormCommand formCommand, Model model) {

		model.addAttribute("message", "");

		model.addAttribute("formCommand", formCommand);
		model.addAttribute("restaurant", getRestaurant());
		
		return "createReview";
	}

	private List<Restaurant> getRestaurant() {

		List<Restaurant> restList = new ArrayList<Restaurant>();
		restList = restService.getRestaurants();
		return restList;
	}

	@RequestMapping(value = "/Review", method = RequestMethod.POST)
	public String orderPost(HttpServletRequest request, @ModelAttribute FormCommand formCommand, Model model) {

		String viewPage = "", message = "";

		String restID = formCommand.getDropdownSelectedValue();
		String reviewTitle = formCommand.getTextField();
		String reviewDescr = formCommand.getTextareaField();
		String rating = formCommand.getNumberField();

		if (reviewTitle.equals("") || reviewDescr.equals("")) {
			model.addAttribute("formCommand", new FormCommand());
			model.addAttribute("restaurant", getRestaurant());
			message = "must have title and description";
			viewPage = "createReview";
		}
		else {
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("customer");

			Review review = new Review(customer.getEmail(), restID, reviewTitle, reviewDescr, rating);
			revService.addReview(review);

			model.addAttribute("review", review);
			message = "Review successful. Here are your results:";
			viewPage = "reviewResults";
		}

		model.addAttribute("message", message);
		return viewPage;
	}
}