package com.ajaxdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class city 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne
	private country country;
	
	public city()
	{
		super();
	}

	public city(int id, String name, country country) 
	{
		super();
		this.id = id;
		this.name = name;
		this.country = country;
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

	public country getCountry() 
	{
		return country;
	}

	public void setCountry(country country) 
	{
		this.country = country;
	}

	@Override
	public String toString()
	{
		return "city [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
}
