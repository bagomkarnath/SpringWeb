package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.model.MessageModel;

@Controller
public class HelloWorldController {

	@RequestMapping("/helloworld")
	public String handler(Model model) {
		MessageModel message = new MessageModel();
		message.setMessage("Hello there !!!");
		model.addAttribute("myMessage", message);
		model.addAttribute("greetings", "Good morning");
		return "helloworld";
	}
}