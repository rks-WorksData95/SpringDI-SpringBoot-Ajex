package com.springbootwebapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootwebapp.model.Todo;

@Service
public class TodoService 
{
	private static List<Todo> todos=new ArrayList<Todo>();
	private static int todoCount=3;
	
	static 
	{
		todos.add(new Todo(1, "Cignex", "Learn Spring Boot", new Date(), false));
		todos.add(new Todo(2, "Cignex", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "Cignex", "Learn Hibernate", new Date(), false));
	}
	
	public List<Todo> retriveTodos(String user)
	{
		List<Todo> filteredTodos=new ArrayList<Todo>();
		for(Todo todo : todos)
		{
			if(todo.getUser().equals(user))
			{
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone)
	{
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}
	
	public Todo retriveTodo(int id)
	{
		for(Todo todo : todos)
		{
			if(todo.getId()==id)
			{
				return todo;
			}
		}
		return null;
	}
	
	public void updateTodo(Todo todo)
	{
		todos.remove(todo);
		todos.add(todo);
	}
	
	public void deleteTodo(int id)
	{
		Iterator<Todo> iterrator=todos.iterator();
		while(iterrator.hasNext())
		{
			Todo todo=iterrator.next();
			if(todo.getId()==id)
			{
				iterrator.remove();
			}
		}
	}
	
}
