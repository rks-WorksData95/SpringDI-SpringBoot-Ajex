package com.jpawithhibernateadvance.repository;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpawithhibernateadvance.entity.Course;

@Repository
@Transactional
public class CourseRepository 
{
	@Autowired
	EntityManager em;
	
	public Course findById(long id)
	{
		return em.find(Course.class, id);
	}
	
	public Course save(Course course) 
	{
		Long id=course.getId();
		if (id == null) 
		{
			em.persist(course);
		}
		else
		{
			em.merge(course);
		}
		return course;
	}
	
	public void deleteById(long id)
	{
		Course course = findById(id);
		em.remove(course);
	}
	
	public void playWithEntityManager() 
	{
		Course course1 = new Course("Web Services in 100 Steps");
		em.persist(course1);	
		
		course1.setName(null);
	}
}
