package com.jdbctemplate.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbctemplate.model.Employee;

public class EmployeeDao 
{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public int saveEmployee(Employee e) throws DataAccessException
	{
		String Query="insert into employee values('"+e.getName()+"','"+e.getSalary()+"')";
		return jdbcTemplate.update(Query);
	}
	
	public int updateEmployee(Employee e)
	{
		return 0;	
	}
	
	public int deleteEmployee(Employee e)
	{
		return 0;
	}
	
}
