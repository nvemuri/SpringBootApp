package com.example.springBoot.dao;

import java.util.List;

import com.example.springBoot.domain.Customer;

public interface ICustomerDAO {
	public void addCustomer(Customer customer);
	public List<Customer> findAllUsers();
	public Customer getCustomer(String id);
	public void updateCustomerr(String id, Customer customer);
	public void deleteCustomer(String id);
	public Customer searchCustomer(String name);
}
