package com.example.springBoot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBoot.domain.User;
import com.example.springBoot.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserService userService;

	@Override
	public void addUser(User user) {
		System.out.println("Adding user....");
		
	}

	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "temp", true , 22, 50000));
		users.add(new User(2, "temp", true , 22, 50000));
		users.add(new User(3, "temp", true , 22, 50000));
		users.add(new User(4, "temp", true , 22, 50000));
		users.add(new User(5, "temp", true , 22, 50000));
		
		return users;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

}
