package com.example.springBoot.dao.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.springBoot.domain.Customer;

@Component
public class Database {
	
	HashMap<String, Customer> customers = new HashMap<>();
	
	public  Database() {
		customers.put("1", new Customer("1","temp1", "temp1l", "temp1@gmail.com", "1343654", "1Atemp"));
		customers.put("2", new Customer("2","temp2", "temp2l", "temp2@gmail.com", "2343654", "2Atemp"));
		customers.put("3", new Customer("3","temp3", "temp3l", "temp3@gmail.com", "3343654", "3Atemp"));
		customers.put("4", new Customer("4","temp4", "temp4l", "temp4@gmail.com", "4343654", "4Atemp"));
	}
	
	public List<Customer> findAllUsers() {				
		return new ArrayList<>(customers.values());
	}

	public void addCustomer(Customer customer) {
		if(customers.get(customer.getId()) != null)
			customers.put(customer.getId(), customer);
		else 
			throw new IllegalArgumentException("Customer already exists with id="+customer.getId());
		
		System.out.println("customers size after add="+customers.size());
	}
	
	public Customer getCustomer(String id) {
		return customers.get(id);
	}
	public void updateCustomerr(String id, Customer customer) {
		
		if(customers.get(id) != null) {
			customers.put(id, customer);
			System.out.println("Update customer...");
		}else {
			System.out.println("Customer not available...");
		}
		
	}
	public void deleteCustomer(String id) {
		customers.remove(id);
		System.out.println("customers size after remove="+customers.size());
	}
	
	public boolean containsCustomer(final List<Customer> list, final String id){
	    return list.stream().anyMatch(w -> w.getId().equals(id));
	}
}
