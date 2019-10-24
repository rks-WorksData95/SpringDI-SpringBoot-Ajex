package com.jpawithhibernateadvance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;

	protected Course()
	{
		super();
	}

	public Course(String name) 
	{
		super();
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
	
	@Override
	public String toString() 
	{
		return String.format("Course[%s]", name);
	}
}
