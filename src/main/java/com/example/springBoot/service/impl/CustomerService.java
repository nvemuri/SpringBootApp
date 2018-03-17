package com.example.springBoot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springBoot.dao.ICustomerDAO;
import com.example.springBoot.domain.Customer;
import com.example.springBoot.service.ICustomerService;

@Component
public class CustomerService implements ICustomerService{
	
	@Autowired
	private ICustomerDAO customerDAO;

	@Override
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Override
	public List<Customer> findAllUsers() {
		return customerDAO.findAllUsers();
	}

	@Override
	public Customer getCustomer(String id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	public void updateCustomer(String id, Customer customer) {
		customerDAO.updateCustomerr(id, customer);
	}

	@Override
	public void deleteCustomer(String id) {
		customerDAO.deleteCustomer(id);		
	}

	
}
