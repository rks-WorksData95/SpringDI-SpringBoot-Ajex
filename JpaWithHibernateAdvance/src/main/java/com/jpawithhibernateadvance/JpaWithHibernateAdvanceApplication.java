package com.jpawithhibernateadvance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpawithhibernateadvance.entity.Course;
import com.jpawithhibernateadvance.repository.CourseRepository;
import com.jpawithhibernateadvance.repository.StudentRepository;

@SpringBootApplication
public class JpaWithHibernateAdvanceApplication implements CommandLineRunner
{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args)
	{
		SpringApplication.run(JpaWithHibernateAdvanceApplication.class, args);
	}
	
	public void run(String... arg0) throws Exception 
	{	
		
		studentRepository.saveStudent();
		//repository.playWithEntityManager();
		
		//logger.info("Course 1 -> {}", repository.save(new Course("Ram")));
		
		/*Course course = repository.findById(4);
		logger.info("Course 1 -> {}", course);
		
		//repository.deleteById(3);
		
		repository.save(new Course("Microservices in 100 Steps"));
		*/	
	}
	
}

