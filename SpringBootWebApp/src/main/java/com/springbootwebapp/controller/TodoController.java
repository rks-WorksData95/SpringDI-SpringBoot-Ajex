package com.springbootwebapp.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbootwebapp.model.Todo;
import com.springbootwebapp.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController
{
	@Autowired
	TodoService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/listtodos" , method=RequestMethod.GET)
	public String showTodos(ModelMap model)
	{
		String name=getLoggedInUserName(model);
		model.put("todos", service.retriveTodos(name));
		
		return "ListTodos";
	}
	
	public String getLoggedInUserName(ModelMap model)
	{
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails)
		{
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
		
		//return (String)model.get("name");
	}
	
	@RequestMapping(value="/addtodo" , method=RequestMethod.GET)
	public String showAddTodoPage(ModelMap model)
	{
		model.addAttribute("Todo", new Todo(0, getLoggedInUserName(model), "Default Desc", new Date(), false));
		return "Todo";
	}
	
	@RequestMapping(value="/deletetodo" , method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:/listtodos";
	}
	
	@RequestMapping(value="/updatetodo" , method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model)
	{
		Todo todo=service.retriveTodo(id);
		model.put("Todo", todo);
		return "Todo";
	}
	
	@RequestMapping(value="/updatetodo" , method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @ModelAttribute("Todo") @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "Todo";
		}
		
		todo.setUser(getLoggedInUserName(model));
		//todo.setTargetDate(new Date());
		
		service.updateTodo(todo);
		
		return "redirect:/listtodos";
	}
	
	@RequestMapping(value="/addtodo" , method=RequestMethod.POST)
	public String addTodo(ModelMap model, @ModelAttribute("Todo") @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "Todo";
		}

		service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/listtodos";
	}
}

