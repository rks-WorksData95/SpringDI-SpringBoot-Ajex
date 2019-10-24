package com.springbootjdbctojpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootjdbctojpa.jdbc.PersonJdbcDao;
import com.springbootjdbctojpa.model.Person;
import com.springbootjdbctojpa.repository.PersonRepository;

@SpringBootApplication
public class SpringBootJdbcToJpaApplication implements CommandLineRunner
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	@Autowired
	PersonRepository repository;

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootJdbcToJpaApplication.class, args);
	}
	
	int i=40;
	
	public void run(String...args) throws Exception
	{
		i++;
		logger.info("All Users -> {}", dao.findAll());
		logger.info("User Id 1 -> {}", dao.findById(1));
		logger.info("Deleting 2 -> No of Rows Deleted - {}", dao.deleteById(2));
		logger.info("Inserting 10005 -> {}", dao.insert(new Person(i, "Tara", "Berlin", new Date())));
		logger.info("Update 10004 -> {}", dao.update(new Person(i, "Pieter", "Utrecht", new Date())));
		
		logger.info("User id jpa 10001 -> {}", repository.findById(1));
		logger.info("Inserting -> {}", repository.insert(new Person("aaa", "aaa", new Date())));
		logger.info("Update 10003 -> {}", repository.update(new Person(40, "hello", "hello", new Date())));
		repository.deleteById(1);
		logger.info("All users -> {}", repository.findAll());
	}
}

