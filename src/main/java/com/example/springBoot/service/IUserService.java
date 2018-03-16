package com.example.springBoot.service;

import java.util.List;

import com.example.springBoot.domain.User;

public interface IUserService {
	public void addUser(User user);
	public List<User> findAllUsers();
	public User getUser(int id);
	public void updateUser(int id);
	public void deleteUser(int id);
}
