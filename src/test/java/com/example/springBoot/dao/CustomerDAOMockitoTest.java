package com.example.springBoot.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.springBoot.dao.data.Database;
import com.example.springBoot.dao.impl.CustomerDAO;
import com.example.springBoot.domain.Customer;

public class CustomerDAOMockitoTest {

	@Mock
	private Database database;
	
	@InjectMocks
	private CustomerDAO customerDAO;
	
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
		
		Mockito.when(database.findAllUsers()).thenReturn(customers);
		List<Customer> filteredTodos = customerDAO.findAllUsers();
		assertEquals(4, filteredTodos.size());
	}
	

}
