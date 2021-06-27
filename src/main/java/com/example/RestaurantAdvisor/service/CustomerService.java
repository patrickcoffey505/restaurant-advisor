package com.example.RestaurantAdvisor.service;
import java.util.List;

import com.example.RestaurantAdvisor.dao.CustomerDAO;
import com.example.RestaurantAdvisor.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerService {

@Autowired
CustomerDAO custDAO;
	
	public List<Customer> getCustomers() {
		return custDAO.getCustomers();
	}

	public void addCustomer(Customer customer) {
		custDAO.addCustomer(customer);
	}

	public void updateCustPhone(Customer customer) {
		custDAO.updateCustPhone(customer);
	}

	public void updateCustAddress(Customer customer) {
		custDAO.updateCustAddress(customer);
	}

	public void updateCustomer(Customer customer) {
		custDAO.updateCustomer(customer);
	}
}	


