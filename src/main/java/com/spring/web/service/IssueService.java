package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.IssueDAO;
import com.spring.web.model.Issue;

@Service()
public class IssueService {
	
	private IssueDAO issueDao;
	
	@Autowired
	public IssueService(IssueDAO issueDao) {
		this.issueDao = issueDao;
	}

	public List<Issue> getAllIssues(int userId) {
		return issueDao.getAllIssues(userId);
	}
	
	public boolean addOrUpdateIssue(Issue issue) {
		return issueDao.addOrUpdateIssue(issue);
	}
	
	public boolean updateIssueStatus(int issueId, String toStatus) {
		return issueDao.updateIssueStatus(issueId, toStatus);
	}
}
