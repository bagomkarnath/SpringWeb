package com.spring.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IssueMapper implements RowMapper<Issue>{

	public Issue mapRow(ResultSet rs, int rowNum) throws SQLException {
		Issue issue = new Issue();
		
		issue.setId(rs.getInt("ID"));
		issue.setIssueDescription(rs.getString("ISSUE_DESCRIPTION"));
		issue.setUserId(rs.getInt("USER_ID"));
		issue.setStatus(rs.getString("STATUS"));
		issue.setSeverity(rs.getString("SEVERITY"));
		
		return issue;
	}

}
