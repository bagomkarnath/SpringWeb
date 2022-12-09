package com.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.web.model.Issue;
import com.spring.web.model.IssueMapper;

@Component
public class IssueDAOImpl extends BaseDAOImpl implements IssueDAO {
	
	private final String QUERY_GET_ALL_ISSUES_FOR_USER = "SELECT * FROM ISSUES WHERE USER_ID = ? AND STATUS = 'OPEN'";
	private final String QUERY_GET_ALL_ISSUES = "SELECT * FROM ISSUES WHERE STATUS = 'OPEN'";
	private final String QUERY_INSERT_ISSUE = "INSERT INTO ISSUES(ID, ISSUE_DESCRIPTION, USER_ID, STATUS, SEVERITY) VALUES(?,?,?,?,?)";
	private final String QUERY_UPDATE_ISSUE_STATUS_TO_RESOLVED = "UPDATE ISSUES SET STATUS = ? WHERE ID = ?";

	@Autowired
	public IssueDAOImpl(DataSource dataSource) {
		super(dataSource);
	}
	
	public List<Issue> getAllIssues(int userId) {
		if (userId == 0) {
			return jdbcTemplate.query(QUERY_GET_ALL_ISSUES, new IssueMapper());
		} else {
			return jdbcTemplate.query(QUERY_GET_ALL_ISSUES_FOR_USER, new IssueMapper(), userId);
		}
	}

	public boolean addOrUpdateIssue(Issue issue) {
		return jdbcTemplate.update(QUERY_INSERT_ISSUE, issue.getId(), issue.getIssueDescription(), issue.getUserId(), issue.getStatus(), issue.getSeverity()) > 0;
	}

	public boolean updateIssueStatus(int issueId, String toStatus) {
		return jdbcTemplate.update(QUERY_UPDATE_ISSUE_STATUS_TO_RESOLVED, toStatus, issueId) > 0;
	}

}
