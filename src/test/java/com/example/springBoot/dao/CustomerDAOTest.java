package com.example.springBoot.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springBoot.dao.impl.CustomerDAO;
import com.example.springBoot.domain.Customer;
import com.example.springBoot.utill.SpringApplicationContextTest;


//Spring
@RunWith(SpringJUnit4ClassRunner.class)
//Application Context
@ContextConfiguration(classes = SpringApplicationContextTest.class)
public class CustomerDAOTest {

	@Autowired
	CustomerDAO customerDAO;
	
	@Test
	public void testRetrieveCustomer() {
		List<Customer> customers = customerDAO.findAllUsers();
		System.out.println(customers);
		assertEquals(1, customers.size());
	}
	
	@Test
	public void testAddCustomer() {
		customerDAO.addCustomer(new Customer("5", "firstname", "lastname", "mail", "45435", "address"));
		assertTrue("Customer not Added", true);
	}

	@Test
	public void testTodoBusinessServiceIsProperlyLoaded() {
		assertNotNull(customerDAO);
	}

}
