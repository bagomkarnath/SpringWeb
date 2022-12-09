package com.spring.web.dao;

import java.util.List;

import com.spring.web.model.Issue;

public interface IssueDAO {
	List<Issue> getAllIssues(int userId);
	boolean addOrUpdateIssue(Issue issue);
	boolean updateIssueStatus(int issueId, String toStatus);
}
