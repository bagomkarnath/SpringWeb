package com.spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.Issue;
import com.spring.web.model.User;
import com.spring.web.service.IssueService;

@Controller
public class ManageIssueController {
	
	private IssueService issueService;
	
	@Autowired
	public void setIssueService(IssueService issueService) {
		this.issueService = issueService;
	}
	
	@PostMapping("add-issue")
	public String addIssue(@ModelAttribute("newIssue") Issue issue) {
		return "add-issue";
	}
	
	@PostMapping("add")
	public String add(@ModelAttribute("newIssue") Issue issue, Model model, HttpSession session) {
		int idGen = (int) Math.ceil(Math.random() * 10000);
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		issue.setId(idGen);
		issue.setStatus("OPEN");
		issue.setUserId(loggedInUser.getId());
		boolean isIssueSaved = issueService.addOrUpdateIssue(issue);
		if (isIssueSaved) {
			model.addAttribute("message", "Issue " + idGen + " saved successfully");
		} else {
			model.addAttribute("message", "Error occurred while raising Issue. Please contact Admin");
		}
		List<Issue> issueList = issueService.getAllIssues(loggedInUser.getId());
		model.addAttribute("issueList", issueList);
		model.addAttribute("isAdmin", "ADMIN".equalsIgnoreCase(loggedInUser.getType()));
		return "issues";
	}
	
	@RequestMapping(path = "resolve", method = RequestMethod.POST)
	public String resolverIssue(@RequestParam("toBeResolvedIssueId") int issueId, @ModelAttribute("newIssue") Issue issue, Model model, HttpSession session) {
		System.out.println("Issue to be resolved : " + issueId);
		boolean isClosed = issueService.updateIssueStatus(issueId, "RESOLVED");
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (isClosed) {
			model.addAttribute("message", "Issue " + issueId + " resolved");
		} else {
			model.addAttribute("message", "Error occurred while resolving Issue. Please contact Admin");
		}
		List<Issue> issueList = issueService.getAllIssues(issue.getUserId());
		model.addAttribute("issueList", issueList);
		model.addAttribute("isAdmin", "ADMIN".equalsIgnoreCase(loggedInUser.getType()));
		return "issues";
	}
	
	@PostMapping("close")
	public String closeIssue(@RequestParam("toBeDeletedIssueId") int issueId, @ModelAttribute("newIssue") Issue issue, Model model, HttpSession session) {
		System.out.println("Issue to be closed : " + issueId);
		boolean isClosed = issueService.updateIssueStatus(issueId, "CLOSED");
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (isClosed) {
			model.addAttribute("message", "Issue " + issueId + " closed");
		} else {
			model.addAttribute("message", "Error occurred while closing Issue. Please contact Admin");
		}
		List<Issue> issueList = issueService.getAllIssues(issue.getUserId());
		model.addAttribute("issueList", issueList);
		model.addAttribute("isAdmin", "ADMIN".equalsIgnoreCase(loggedInUser.getType()));
		return "issues";
	}
}
