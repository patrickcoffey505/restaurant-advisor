package com.example.RestaurantAdvisor.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.RestaurantAdvisor.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

	@Autowired
	private RestaurantDatabaseMapper restMapper;
	
	public List<Customer> getCustomers() {
		List<Customer> custList = new ArrayList<Customer>();
		
		custList = restMapper.getCustomers();
		return custList;
	}

	public void addCustomer(Customer customer) {
		restMapper.addCustomer(customer);
	}

	public void updateCustPhone(Customer customer) {
		restMapper.updateCustPhone(customer);
	}

	public void updateCustAddress(Customer customer) {
		restMapper.updateCustAddress(customer);
	}

	public void updateCustomer(Customer customer) {
		restMapper.updateCustomer(customer);
	}
}
