package com.example.springBoot.domain;

public class User {

	public User(int id, String name, boolean status, int age, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.age = age;
		this.sal = sal;
	}
	
	private int id;
	private String name;
	private boolean status;
	private int age;
	private int sal;
	
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	private Task task;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
