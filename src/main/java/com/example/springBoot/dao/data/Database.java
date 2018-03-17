package com.example.springBoot.dao.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.springBoot.domain.Customer;

@Component
public class Database {
	
	List<Customer> customers = new ArrayList<Customer>();
	
	public List<Customer> findAllUsers() {
		customers.add(new Customer("1","temp", "temp", "temp@gmail.com", "4343654", "temp"));
		customers.add(new Customer("2","temp", "temp", "temp@gmail.com", "4343654", "temp"));
		customers.add(new Customer("3","temp", "temp", "temp@gmail.com", "4343654", "temp"));
		customers.add(new Customer("4","temp", "temp", "temp@gmail.com", "4343654", "temp"));
				
		return customers;
	}
	

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public Customer getCustomer(String id) {
		Optional<Customer> customer = customers.stream().filter(cutomer -> cutomer.getId() == id).findFirst();
		return customer.get();
	}
	public void updateCustomerr(String id, Customer customer) {
		
		if(containsCustomer(customers, id)) {
			System.out.println("Update customer...");
		}else {
			System.out.println("Customer not available...");
		}
		
	}
	public void deleteCustomer(String id) {
		customers.removeIf(customer -> customer.getId() == id);
	}
	
	
	public boolean containsCustomer(final List<Customer> list, final String id){
	    return list.stream().filter(o -> o.getId().equals(id)).findFirst().isPresent();
	}
	

}
