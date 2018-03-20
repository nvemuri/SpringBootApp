package com.example.springBoot.service;

import java.util.List;

import com.example.springBoot.domain.Customer;

public interface ICustomerService {
	
	public void addCustomer(Customer customer);
	public List<Customer> findAllUsers();
	public Customer getCustomer(String id);
	public void updateCustomer(String id, Customer customer);
	public void deleteCustomer(String id);
	public  List<Customer> searchCustomer(String name);
}
