package com.springbootwebapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbootwebapp.service.LoginService;

@Controller
@SessionAttributes("name")
public class WelcomeController 
{
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	//@ResponseBody
	public String showLoginMessage(ModelMap model)
	{
		model.put("name", "Cignex");
		return "welcome";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	//@ResponseBody
	public String showWelcomePage(@RequestParam String name , @RequestParam String password , ModelMap model)
	{
		boolean isValidUser=loginService.validateUser(name, password);
		
		if(!isValidUser)
		{
			model.put("errorMessage", "Invalid Credentials.");
			return "Login";
		}
		
		model.put("name", name);
		model.put("password", password);
		
		return "welcome";
	}
}
