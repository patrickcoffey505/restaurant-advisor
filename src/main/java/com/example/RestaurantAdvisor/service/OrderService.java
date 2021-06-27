package com.example.RestaurantAdvisor.service;
import java.util.List;

import com.example.RestaurantAdvisor.dao.OrderDAO;
import com.example.RestaurantAdvisor.domain.Order;
import com.example.RestaurantAdvisor.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderService {

@Autowired
OrderDAO orderDAO;
	
	public List<Order> getOrders(Customer customer) {
		return orderDAO.getOrders(customer);
	}

	public void addOrder(Order order) {
		orderDAO.addOrder(order);
	}

	public String lastOrder() {
		return orderDAO.lastOrder();
	}

}	


