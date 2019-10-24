package com.didemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {
		
		Resource resource=new ClassPathResource("contextApplication.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		Employee emp=(Employee) factory.getBean("employee");
		emp.display(); 
		
		ApplicationContext context=new ClassPathXmlApplicationContext("contextApplication.xml");
		Employee emp1=(Employee)context.getBean("employee");
		emp1.display();
		
	}
	
}
