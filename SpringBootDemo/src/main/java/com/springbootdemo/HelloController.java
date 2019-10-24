package com.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController 
{
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	
	public ModelAndView save(@ModelAttribute user u)
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("UserData");
		mav.addObject("user", u);
		return mav;
	}
}
