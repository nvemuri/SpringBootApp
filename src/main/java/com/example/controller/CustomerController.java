package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.domain.Customer;
import com.example.springBoot.util.ResourceNotFoundException;


//this class is to create, update, get and delete customer details.
@RestController
public class CustomerController {
	
	List<Customer> cust = new ArrayList<Customer>();
	
	//code for to get all customers
	@RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
	public List<Customer> listCustomer(){
		
			cust.add(new Customer("1","temp", "temp", "temp@gmail.com", "4343654", "temp"));
			return cust;
	}
	
	//code for getting requested customer
	@RequestMapping(value = "/getcustomer", method = RequestMethod.GET)
	public Customer getCustomer(@RequestParam String id){
		
		Optional<Customer> customer = cust.stream().filter(cutomer -> cutomer.getId() == id).findFirst();
		
		if(customer.get() == null){
			new ResourceNotFoundException("Customer", "id", id);
		}
		return customer.get();
	}
	
	//code for adding new customer
	@RequestMapping(value="/postcustomer", method=RequestMethod.POST)
	public String postCustomer(@RequestBody Customer customer){
		cust.add(customer);
		return "Sucessful!";
	}
	
	
	//code for update customer
	@RequestMapping(value="/updatecustomer", method=RequestMethod.PUT)
	public String updateCustomer(@RequestParam String id, @RequestBody Customer customer){
		
		Optional<Customer> matchingCustomerObject  = cust.stream().filter(cutomer -> cutomer.getId() == id).findFirst();
		if(matchingCustomerObject.get() == null){
			new ResourceNotFoundException("Customer", "id", id);
		}else{
			customer.setId(id);
			cust.add(customer);
		}
		return "Customer updated Sucessfully!";
	}
	
	
	//code for delete customer
	@RequestMapping(value = "/getcustomer", method = RequestMethod.DELETE)
	public String deleteCustomer(@RequestParam String id){
		
		Optional<Customer> matchingCustomerObject  = cust.stream().filter(cutomer -> cutomer.getId() == id).findFirst();
		if(matchingCustomerObject.get() == null){
			new ResourceNotFoundException("Customer", "id", id);
		}else{
			cust.removeIf(customer -> customer.getId() == id);			
		}
			return "Customer deleted Sucessfully";
	}
}