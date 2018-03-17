package com.example.springBoot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springBoot.dao.ICustomerDAO;
import com.example.springBoot.dao.data.Database;
import com.example.springBoot.domain.Customer;
import com.example.springBoot.domain.User;

@Component
public class CustomerDAO implements ICustomerDAO{
	
	@Autowired
	private Database database;

	@Override
	public void addCustomer(Customer customer) {
		database.addCustomer(customer);
	}

	@Override
	public List<Customer> findAllUsers() {
		return database.findAllUsers();
	}

	@Override
	public Customer getCustomer(String id) {
		return database.getCustomer(id);
	}

	@Override
	public void updateCustomerr(String id, Customer customer) {
		database.updateCustomerr(id, customer);		
	}

	@Override
	public void deleteCustomer(String id) {
		database.deleteCustomer(id);
	}

	
}
