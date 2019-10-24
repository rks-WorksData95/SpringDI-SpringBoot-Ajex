package com.jpawithhibernateadvance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;

	public Student()
	{
		super();
	}

	public Student(String name)
	{
		super();
		this.name = name;
	}

	public Long getId() 
	{
		return id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Passport getPassport() 
	{
		return passport;
	}

	public void setPassport(Passport passport) 
	{
		this.passport = passport;
	}

	@Override
	public String toString() 
	{
		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + "]";
	}
	
}
