package com.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Util.StudentInfo;

public class StudentMain
{
	public static void main(String[] args)
	{
		Configuration cfgobj=new Configuration();
		cfgobj.addAnnotatedClass(com.Util.StudentInfo.class);
		cfgobj.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceregobj=new StandardServiceRegistryBuilder().applySettings(cfgobj.getProperties()).build();
		SessionFactory sessionfactoryobj=cfgobj.buildSessionFactory(serviceregobj);
		
		Session sessionobj=sessionfactoryobj.openSession();
		sessionobj.beginTransaction();
		
		StudentInfo s=new StudentInfo();
		s.setName("Ram");
		s.setAddress("Mandal");
		sessionobj.save(s);
		
		sessionobj.getTransaction().commit();
		sessionobj.close();
	}
}
