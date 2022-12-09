package com.spring.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.Issue;
import com.spring.web.model.User;
import com.spring.web.service.IssueService;
import com.spring.web.service.UserService;

@Controller
public class LoginController {
	
	private UserService userService;
	private IssueService issueService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setIssueService(IssueService issueService) {
		this.issueService = issueService;
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("signup")
	public String signUp(Model model) {
		User user = new User();
		model.addAttribute("newUser", user);
		return "signup";
	}
	
	@PostMapping(path = "/auth")
	public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
		User user = userService.getUserByUsernameAndPassword(username, password);
		if (user != null) {
			//model.addAttribute("loggedInUser", user);
			session.setAttribute("loggedInUser", user);
			List<Issue> issueList = new ArrayList<Issue>();
			if ("ADMIN".equalsIgnoreCase(user.getType())) {
				System.out.println("Admin [" + user.getId() + "] logged in type : " + user.getType() );
				issueList = issueService.getAllIssues(0);
			} else {
				System.out.println("User [" + user.getId() + "] logged in type : " + user.getType() );
				issueList = issueService.getAllIssues(user.getId());
			}
			model.addAttribute("issueList", issueList);
			model.addAttribute("isAdmin", "ADMIN".equalsIgnoreCase(user.getType()));
			return "issues";
		} else {
			return "login";
		}
	}
}
