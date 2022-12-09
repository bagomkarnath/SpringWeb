package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.web.model.User;
import com.spring.web.service.UserService;

@Controller
public class RegistrationController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(path = "/register")
	public String register(@ModelAttribute("newUser") User newUser) {
		int idGen = (int) Math.ceil(Math.random() * 10000);
		newUser.setId(idGen);
		newUser.setType("USER");
		boolean isUserCreationSuccess = userService.saveUser(newUser);
		if (isUserCreationSuccess) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("FAIL");
		}
		return "login";
	}
}
