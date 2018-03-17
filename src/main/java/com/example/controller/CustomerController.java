package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.domain.Customer;
import com.example.springBoot.service.impl.CustomerService;
import com.example.springBoot.util.ResourceNotFoundException;


//this class is to create, update, get and delete customer details.
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//code for to get all customers
	@RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
	public List<Customer> listCustomer(){
			return customerService.findAllUsers();
	}
	
	//code for getting requested customer
	@RequestMapping(value = "/getcustomer", method = RequestMethod.GET)
	public Customer getCustomer(@RequestParam String id){
		
		Customer customer = customerService.getCustomer(id);
		if(customer == null){
			new ResourceNotFoundException("Customer", "id", id);
		}
		return customer;
	}
	
	//code for adding new customer
	@RequestMapping(value="/postcustomer", method=RequestMethod.POST)
	public String postCustomer(@RequestBody Customer customer){
		
		customerService.addCustomer(customer);
		return "Sucessful!";
	}
	
	//code for update customer
	@RequestMapping(value="/updatecustomer", method=RequestMethod.PUT)
	public String updateCustomer(@RequestParam String id, @RequestBody Customer customer){
		customerService.updateCustomer(id, customer);
		return "Customer updated Sucessfully!";
	}
	
	//code for delete customer
	@RequestMapping(value = "/getcustomer", method = RequestMethod.DELETE)
	public String deleteCustomer(@RequestParam String id){
		customerService.deleteCustomer(id);
		return "Customer deleted Sucessfully";
	}
}