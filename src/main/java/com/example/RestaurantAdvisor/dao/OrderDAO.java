package com.example.RestaurantAdvisor.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.RestaurantAdvisor.domain.Customer;
import com.example.RestaurantAdvisor.domain.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO {

	@Autowired
	private RestaurantDatabaseMapper restMapper;
	
	public List<Order> getOrders(Customer customer) {
		List<Order> orderList = new ArrayList<Order>();
		
		orderList = restMapper.getOrders(customer);
		return orderList;
	}

	public void addOrder(Order order) {
		restMapper.addOrder(order);
	}

	public String lastOrder() {
		return restMapper.lastOrder();
	}

}
