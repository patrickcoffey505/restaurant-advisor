package com.example.RestaurantAdvisor.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.RestaurantAdvisor.domain.Restaurant;
import com.example.RestaurantAdvisor.domain.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuDAO {

	@Autowired
	private RestaurantDatabaseMapper restMapper;
	
	public List<Menu> getMenu(Restaurant restaurant) {
		List<Menu> menuList = new ArrayList<Menu>();
		
		menuList = restMapper.getMenu(restaurant);
		return menuList;
	}
}
