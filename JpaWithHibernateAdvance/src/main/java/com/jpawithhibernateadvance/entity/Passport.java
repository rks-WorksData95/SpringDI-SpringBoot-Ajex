package com.jpawithhibernateadvance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passport 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String number;
	
	public Passport()
	{
		super();
	}

	public Passport(String number) 
	{
		super();
		this.number = number;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number) 
	{
		this.number = number;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
}
