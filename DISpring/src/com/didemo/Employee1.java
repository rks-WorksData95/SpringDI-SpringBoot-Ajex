package com.didemo;

public class Employee1 {
	private int id;
	private String name;
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
	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + "]";
	}
	
	public void display()
	{
		System.out.println("Id: "+id+" Name: "+name);
	}
	
}
