package com.example.RestaurantAdvisor.service;

import java.util.List;

import com.example.RestaurantAdvisor.dao.OrderItemDAO;
import com.example.RestaurantAdvisor.domain.Order;
import com.example.RestaurantAdvisor.domain.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderItemService {

@Autowired
OrderItemDAO detailsDAO;

	public void addDetails(OrderItem employee) {
		detailsDAO.addDetails(employee);
	}

	public List<OrderItem> getDetails(Order order) {
	
		return detailsDAO.getDetails(order);		
	}

	
}	


