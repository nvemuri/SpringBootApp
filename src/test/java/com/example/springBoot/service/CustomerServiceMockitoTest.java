package com.example.springBoot.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.springBoot.dao.impl.CustomerDAO;
import com.example.springBoot.domain.Customer;
import com.example.springBoot.service.impl.CustomerService;

public class CustomerServiceMockitoTest {
	
	@Mock
	private CustomerDAO customerDAO;

	@InjectMocks
	private CustomerService customerService;

	@Before
	public void initializeMockito() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveCustomersRelatedToSpring() {
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("1","temp", "temp", "temp@gmail.com", "4343654", "temp"));
		customers.add(new Customer("2","temp", "temp", "temp@gmail.com", "4343654", "temp"));
		customers.add(new Customer("3","temp", "temp", "temp@gmail.com", "4343654", "temp"));
		customers.add(new Customer("4","temp", "temp", "temp@gmail.com", "4343654", "temp"));
		
		Mockito.when(customerDAO.findAllUsers()).thenReturn(customers);
		List<Customer> filteredTodos = customerService.findAllUsers();
		assertEquals(4, filteredTodos.size());
	}
	
}
