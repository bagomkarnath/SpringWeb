package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.model.MessageModel;
import com.spring.web.model.Student;

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
	
	@RequestMapping("/display/{message}")
	public String pathParamsExample(@PathVariable("message") String msg, Model model) {
		model.addAttribute("processedMessage", msg.toUpperCase());
		return "path-params-ex";
	}
	
	@RequestMapping("process-student")
	public String formSubmitted(@ModelAttribute("formStudent") Student std) {
		return "form-result";
	}
	
	@RequestMapping("student-form")
	public String studentForm(Model model) {
		Student s = new Student();
		model.addAttribute("formStudent", s);
		return "student-form";
	}
}