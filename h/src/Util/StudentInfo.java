package com.Util;

import javax.persistence.*;

@Entity
@Table(name="StudentInfo")
public class StudentInfo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="StudentId")
	private int Id;	
	
	@Column(name="StudentName")
	private String Name;
	
	@Column(name="StudentAddress")
	private String Address;
	
	public StudentInfo()
	{
		super();
	}
		
	public StudentInfo(int id, String name, String address)
	 {
		super();
		Id = id;
		Name = name;
		Address = address;
	}

	public int getId() 
	{
		return Id;
	}
	
	public void setId(int id) 
	{
		Id = id;
	}
	
	public String getName() 
	{
		return Name;
	}
	
	public void setName(String name) 
	{
		Name = name;
	}
	
	public String getAddress() 
	{
		return Address;
	}
	
	public void setAddress(String address) 
	{
		Address = address;
	}
	
}
