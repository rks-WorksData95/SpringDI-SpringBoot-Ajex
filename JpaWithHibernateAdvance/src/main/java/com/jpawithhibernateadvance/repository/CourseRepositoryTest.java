package com.jpawithhibernateadvance.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpawithhibernateadvance.JpaWithHibernateAdvanceApplication;
import com.jpawithhibernateadvance.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaWithHibernateAdvanceApplication.class)
public class CourseRepositoryTest 
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	public void findById_basic() {
		Course course = repository.findById(2);
		assertEquals("JPA in 50 Steps", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic()
	{
		repository.deleteById(2);
		assertNull(repository.findById(2));
	}	
	
	@Test
	@DirtiesContext
	public void save_basic() {

		// get a course
		Course course = repository.findById(7);
		assertEquals("JPA in 50 Steps", course.getName());

		// update details
		course.setName("JPA in 50 Steps - Updated");

		repository.save(course);

		// check the value
		Course course1 = repository.findById(4);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}
	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
}
