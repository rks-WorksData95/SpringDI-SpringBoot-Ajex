package com.springbootwebapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootwebapp.model.Todo;
import com.springbootwebapp.service.TodoService;

@RestController
public class TodoRestController 
{
	@Autowired
	private TodoService service;
	
	@RequestMapping(value="/resttodos", method=RequestMethod.GET)
	public List<Todo> listAllTodos()
	{
		List<Todo> users=service.retriveTodos("Cignex");
		
		return users;
	}
	
	@RequestMapping(value="resttodos/{id}", method=RequestMethod.GET)
	public Todo retriveTodo(@PathVariable("id") int id)
	{
		return service.retriveTodo(id);
	}
}
