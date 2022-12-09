package com.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.spring.web.model.User;
import com.spring.web.model.UserMapper;

@Component
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
	
	private final String QUERY_GET_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
	private final String QUERY_GET_ALL_USERS = "SELECT * FROM USERS";
	private final String QUERY_INSERT_USER = "INSERT INTO USERS(ID, USERNAME, PASSWORD, TYPE) VALUES(?,?,?,?)";

	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		super(dataSource);
	}

	public User getUserByUsernameAndPassword(String username, String password) {
		try {
			return jdbcTemplate.queryForObject(QUERY_GET_USER_BY_USERNAME_AND_PASSWORD, new UserMapper(), username, password);
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAllUsers() {
		return jdbcTemplate.query(QUERY_GET_ALL_USERS, new UserMapper());
	}

	public boolean saveUser(User user) {
		return jdbcTemplate.update(QUERY_INSERT_USER, user.getId(), user.getUserName(), user.getPassword(), user.getType()) > 0;  
	}

}
