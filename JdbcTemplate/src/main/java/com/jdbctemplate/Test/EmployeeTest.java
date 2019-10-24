package com.jdbctemplate.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbctemplate.dao.EmployeeDao;
import com.jdbctemplate.model.Employee;

public class EmployeeTest 
{

	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao emp=(EmployeeDao) context.getBean("edao");
		Employee e=new Employee();
		e.setName("Ram");
		e.setSalary("25000");
		int status=emp.saveEmployee(e);
		if(status==1)
		System.out.println("Query Executed Successfully..."+status);
	}

}
