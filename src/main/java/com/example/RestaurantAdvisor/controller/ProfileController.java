package com.example.RestaurantAdvisor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.RestaurantAdvisor.domain.FormCommand;
import com.example.RestaurantAdvisor.domain.Order;
import com.example.RestaurantAdvisor.domain.OrderItem;
import com.example.RestaurantAdvisor.domain.Restaurant;
import com.example.RestaurantAdvisor.domain.Review;
import com.example.RestaurantAdvisor.domain.Customer;
import com.example.RestaurantAdvisor.service.CustomerService;
import com.example.RestaurantAdvisor.service.OrderService;
import com.example.RestaurantAdvisor.service.RestaurantService;
import com.example.RestaurantAdvisor.service.ReviewService;
import com.example.RestaurantAdvisor.service.OrderItemService;

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
public class ProfileController {

	@Autowired
	CustomerService custService;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderItemService orderItemService;

	@Autowired
	ReviewService reviewService;

	@Autowired
	RestaurantService restService;

	@RequestMapping(value = "/Profile", method = RequestMethod.GET)
	public String viewProfile(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");

		List<Order> orders = orderService.getOrders(customer);

		List<Restaurant> restList = restService.getRestaurants();

		for (Order o : orders) {
			List<OrderItem> items = orderItemService.getDetails(o);
			if (items.size() > 0) {

				for (Restaurant r : restList) {
					if (r.getRestID().equals(items.get(0).getRestID())) {
						o.setRestID(r.getRName());
					}
				}
			}
		}

		List<Review> reviews = reviewService.getReviewsCust(customer);

		for (Review rev : reviews) {
			for (Restaurant r : restList) {
				if (r.getRestID().equals(rev.getRestID())) {
					rev.setRestID(r.getRName());
				}
			}
		}

		model.addAttribute("customer", customer);
		model.addAttribute("orders", orders);
		model.addAttribute("reviews", reviews);

		return "profile";
	}

	@RequestMapping(value = "/EditProfile", method = RequestMethod.GET)
	public String editProfile(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");

		model.addAttribute("customer", customer);
		model.addAttribute("message", "");

		return "editProfile";
	}

	@RequestMapping(value = "/EditProfile", method = RequestMethod.POST)
	public String saveCustomer(HttpServletRequest request, @ModelAttribute Customer customer, Model model) {
		
		String viewPage = "", message = "";
		boolean correct_password;

		HttpSession session = request.getSession();
		Customer previous = (Customer) session.getAttribute("customer");

		correct_password = customer.getPassword().equals(previous.getPassword());

		if (correct_password) {
			customer.setEmail(previous.getEmail());
			custService.updateCustomer(customer);
			
			if (!(customer.getPhone() == "")) { custService.updateCustPhone(customer); }
			if (!(customer.getStreetNo() == "")) { custService.updateCustAddress(customer); }

			session.setAttribute("customer", customer);
			message = "update successful";
			viewPage = "profile";
		} 
		
		else {
			message = "incorrect password";
			viewPage = "editProfile";
		}
		
		model.addAttribute("customer", customer);
		model.addAttribute("message", message);
		
		return viewPage;
	}
}