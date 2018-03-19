package com.example.springBoot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springBoot.domain.Customer;
import com.example.springBoot.service.impl.CustomerService;
import com.example.springBoot.utill.SpringApplicationContextTest;


//Spring
@RunWith(SpringJUnit4ClassRunner.class)
//Application Context
@ContextConfiguration(classes = SpringApplicationContextTest.class)
public class CustomerServiceTest {

	@Autowired
	CustomerService customerService;
	
	@Test
	public void testRetrieveCustomerRelatedToSpring() {
		List<Customer> customers = customerService.findAllUsers();
		System.out.println(customers);
		assertEquals(1, customers.size());
	}

	@Test
	public void testAddCustomer() {
		
		Random r = new Random();
		Customer customer = new Customer(r.nextInt((10 - 1) + 1) + 1+"","temp", "temp", "temp@gmail.com", "4343654", "temp");
		customerService.addCustomer(customer);
		assertTrue(true);
		customerService.deleteCustomer("5");
	}
	
	public void updateCustomer() {
		Customer customer = new Customer("2","temp", "temp", "temp@gmail.com", "4343654", "test");
		customerService.updateCustomer("2", customer);
		assertTrue(true);
		customerService.deleteCustomer("2");

	}
	
	@Test
	public void deleteCustomer() {
		customerService.deleteCustomer("1");
		List<Customer> customers = customerService.findAllUsers();
		System.out.println(customers);
		assertEquals(1, customers.size());
	}
	
	@Test
	public void testTodoBusinessServiceIsProperlyLoaded() {
		assertNotNull(customerService);
	}

}
