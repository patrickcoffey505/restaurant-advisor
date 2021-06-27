package com.example.RestaurantAdvisor.service;
import java.util.List;

import com.example.RestaurantAdvisor.dao.MenuDAO;
import com.example.RestaurantAdvisor.domain.Menu;
import com.example.RestaurantAdvisor.domain.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MenuService {

@Autowired
MenuDAO menuDAO;
	
	public List<Menu> getMenu(Restaurant restaurant) {
		
		return menuDAO.getMenu(restaurant);
	}
}	


