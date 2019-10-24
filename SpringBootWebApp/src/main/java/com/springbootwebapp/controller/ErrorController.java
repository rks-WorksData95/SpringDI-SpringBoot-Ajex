package com.springbootwebapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController
{
	private Log logger=LogFactory.getLog(ErrorController.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception ex)
	{
		logger.error("Request: "+request.getRequestURL()+"raised "+ex);
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("exception", ex.getLocalizedMessage());
		mav.addObject("url", request.getRequestURL());
		
		mav.setViewName("error");
		
		return mav;
	}
}
