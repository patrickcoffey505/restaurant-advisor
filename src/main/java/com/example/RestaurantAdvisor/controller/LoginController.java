package com.example.RestaurantAdvisor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.RestaurantAdvisor.domain.FormCommand;
import com.example.RestaurantAdvisor.domain.Customer;
import com.example.RestaurantAdvisor.service.CustomerService;
import com.example.RestaurantAdvisor.domain.Restaurant;
import com.example.RestaurantAdvisor.service.RestaurantService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LoginController {

	@Autowired
	CustomerService custService;

	@Autowired
	RestaurantService restService;

	@RequestMapping(value = "/RestaurantLogin", method = RequestMethod.GET)
	public String restLogin(@ModelAttribute Customer customer, Model model) {

		String message = "Please enter email and password :";

		model.addAttribute("customer", customer);
		model.addAttribute("message", message);

		return "login";
	}

	@RequestMapping(value = "/RestaurantLogin", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, @ModelAttribute Customer customer, Model model) {

		String viewPage = "", message = "email is not registered";
		boolean valid = false;

		HttpSession session = request.getSession();

		String email = customer.getEmail();
		String password = customer.getPassword();

		List<Customer> custList = new ArrayList<Customer>();
		custList = custService.getCustomers();
		
		for (Customer c : custList) {
			if (email.equals(c.getEmail())) {

				if (password.equals(c.getPassword())) {
					List<Restaurant> restList = new ArrayList<Restaurant>();
					restList = restService.getRestaurants();
					model.addAttribute("restList", restList);

					viewPage = "home";
					session.setAttribute("customer", c);
					valid = true;

				} else {
					message = "invalid password";
				}
			}
		}

		if (!valid) {
			viewPage = "login";
			customer = new Customer();
			session.invalidate();
		}

		model.addAttribute("customer", customer);
		model.addAttribute("message", message);

		return viewPage;
	}

	@RequestMapping(value = "/NewUser", method = RequestMethod.GET)
	public String register(@ModelAttribute Customer customer, Model model) {

		model.addAttribute("customer", customer);

		return "register";
	}

	@RequestMapping(value = "/NewUser", method = RequestMethod.POST)
	public String registerPost(HttpServletRequest request, @ModelAttribute Customer customer, Model model) {

		String viewPage = "", message = "email is already linked to an account";
		boolean valid = true;

		HttpSession session = request.getSession();

		String email = customer.getEmail();
		String password = customer.getPassword();
		String fName = customer.getFName();
		String lName = customer.getLName();

		if (email == "" || password == "" || fName == "" || lName == "") {
			message = "must enter valid first name, last name, email, and password";
			valid = false;
		} else {
			List<Customer> custList = new ArrayList<Customer>();
			custList = custService.getCustomers();

			for (Customer c : custList) {
				if (email.equals(c.getEmail())) { valid = false; }
			}
		}

		if (!valid) {
			viewPage = "register";
			customer = new Customer();
			session.invalidate();
		} else {
			session.setAttribute("customer", customer);

			custService.addCustomer(customer);

			if (!(customer.getPhone() == "")) { custService.updateCustPhone(customer); }
			if (!(customer.getStreetNo() == "")) { custService.updateCustAddress(customer); }

			List<Restaurant> restList = new ArrayList<Restaurant>();
			restList = restService.getRestaurants();
			model.addAttribute("restList", restList);

			message = "login successful";
			viewPage = "home";
		}

		model.addAttribute("customer", customer);
		model.addAttribute("message", message);

		return viewPage;
	}

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String landing(HttpServletRequest request, Model model) {

		List<Restaurant> restList = new ArrayList<Restaurant>();
		restList = restService.getRestaurants();

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");

		model.addAttribute("restList", restList);
		model.addAttribute("customer", customer);

		return "home";
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, @ModelAttribute Customer customer, Model model) {

		HttpSession session = request.getSession();
		session.invalidate();

		String message = "Please enter email and password :";

		model.addAttribute("message", message);
		model.addAttribute("customer", customer);

		return "login";

	}
}