package com.jpawithhibernateadvance.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpawithhibernateadvance.entity.Passport;
import com.jpawithhibernateadvance.entity.Student;

@Repository
@Transactional
public class StudentRepository
{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void saveStudent()
	{
		Passport passport=new Passport("Z123456");
		em.persist(passport);
		
		Student student=new Student("Ram");
		student.setPassport(passport);
		
		em.persist(student);
	}
}
