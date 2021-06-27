package com.example.RestaurantAdvisor.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.RestaurantAdvisor.domain.Order;
import com.example.RestaurantAdvisor.domain.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemDAO {

	@Autowired
	private RestaurantDatabaseMapper restMapper;
	
	public void addDetails(OrderItem orderItem) {
	
		restMapper.addDetails(orderItem);		
	}

	public List<OrderItem> getDetails(Order order) {
	
		return restMapper.getDetails(order);		
	}
}
