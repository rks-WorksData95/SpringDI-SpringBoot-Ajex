package com.springbootwebapp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService 
{
	public boolean validateUser(String username, String password)
	{
		return username.equalsIgnoreCase("Cignex") && password.equalsIgnoreCase("cignex");
	}
}
