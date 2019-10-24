package com.ajaxdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class country 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	public country() 
	{
		super();
	}

	public country(int id, String name) 
	{
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	@Override
	public String toString() 
	{
		return "country [id=" + id + ", name=" + name + "]";
	}
}
