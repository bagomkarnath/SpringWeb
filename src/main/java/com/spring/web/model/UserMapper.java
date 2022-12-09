package com.spring.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setId(rs.getInt("ID"));
		user.setUserName(rs.getString("USERNAME"));
		user.setType(rs.getString("TYPE"));
		
		return user;
	}

}
