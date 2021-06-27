package com.example.RestaurantAdvisor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.RestaurantAdvisor.domain.Customer;
import com.example.RestaurantAdvisor.domain.FormCommand;
import com.example.RestaurantAdvisor.domain.ItemList;
import com.example.RestaurantAdvisor.domain.Restaurant;
import com.example.RestaurantAdvisor.service.RestaurantService;
import com.example.RestaurantAdvisor.domain.Order;
import com.example.RestaurantAdvisor.service.OrderService;
import com.example.RestaurantAdvisor.domain.Menu;
import com.example.RestaurantAdvisor.service.MenuService;
import com.example.RestaurantAdvisor.domain.OrderItem;
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
public class OrderController {

	@Autowired
	RestaurantService restService;

	@Autowired
	OrderService orderService;

	@Autowired
	MenuService menuService;

	@Autowired
	OrderItemService orderItemService;

	@RequestMapping(value = "/Order", method = RequestMethod.GET)
	public String createOrder(@ModelAttribute FormCommand formCommand, Model model) {

		model.addAttribute("message", "");

		model.addAttribute("formCommand", formCommand);
		model.addAttribute("type", getType());
		model.addAttribute("restaurant", getRestaurant());
		
		return "createOrder";
	}

	private List<String> getType() {
		List<String> types = new ArrayList<String>();
		types.add("Dine In");
		types.add("Delivery");
		types.add("Pick Up");

		return types;
	}

	private List<Restaurant> getRestaurant() {

		List<Restaurant> restList = new ArrayList<Restaurant>();
		restList = restService.getRestaurants();
		return restList;
	}

	@RequestMapping(value = "/Order", method = RequestMethod.POST)
	public String orderPost(HttpServletRequest request, @ModelAttribute FormCommand formCommand, Model model) {
		
		if (formCommand.getRadioButtonSelectedValue().isEmpty()) {
			model.addAttribute("formCommand", new FormCommand());
			model.addAttribute("type", getType());
			model.addAttribute("restaurant", getRestaurant());
			model.addAttribute("message", "must select dining method");
			return "createOrder";
		}
		else {
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("customer");

			String restID = formCommand.getDropdownSelectedValue();
			String type = formCommand.getRadioButtonSelectedValue();

			Order order = new Order(customer.getEmail());
			order.setRestID(restID);
			order.setType(type);

			List<OrderItem> items = new ArrayList<OrderItem>();

			session.setAttribute("order", order);

			model.addAttribute("order", order);
			model.addAttribute("items", items);

			return "orderResults";
		}
	}

	@RequestMapping(value = "/OrderDetails", method = RequestMethod.GET)
	public String orderDetails(HttpServletRequest request, @ModelAttribute ItemList itemform, Model model) {
		
		List<Restaurant> restList = new ArrayList<Restaurant>();
		restList = restService.getRestaurants();

		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");

		List<Menu> menu = new ArrayList<Menu>();
		
		for (Restaurant r : restList) {
			if (order.getRestID().equals(r.getRestID())) {
				menu = menuService.getMenu(r);
			}
		}
		
		for (Menu m : menu) {
			itemform.addItem(new OrderItem(m.getFoodName(), m.getPrice()));
		}

		model.addAttribute("itemform", itemform);

		System.out.println(model.getAttribute("itemform"));
		
		return "orderDetails";
	}

	@RequestMapping(value = "/OrderDetails", method = RequestMethod.POST)
	public String orderResults(HttpServletRequest request, @ModelAttribute ItemList itemform, Model model) {

		double totalCost = 0;

		List<OrderItem> items = itemform.getOrderitems();

		System.out.println("here");
		System.out.println(items);

		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");

		orderService.addOrder(order);

		for (OrderItem i : items) {
			if (i.getQty().equals("0")) { items.remove(i); }
			else {
				i.setRestID(order.getRestID());
				i.setOno(order.getOno());

				orderItemService.addDetails(i);

				totalCost += Integer.parseInt(i.getQty()) * Double.parseDouble(i.getPrice());
			}
		}

		if (items.isEmpty()) {
			model.addAttribute("message", "no items ordered");
			model.addAttribute("formCommand", new FormCommand());
			model.addAttribute("type", getType());
			model.addAttribute("restaurant", getRestaurant());
			return "createOrder";
		}
		else {
			model.addAttribute("orderItems", items);
			model.addAttribute("order", order);
			model.addAttribute("total", Double.toString(totalCost));

			return "orderDetailsResults";
		}
	}
}