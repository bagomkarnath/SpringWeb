package com.spring.web.dao;

import java.util.List;

import com.spring.web.model.User;

public interface UserDAO {
	User getUserByUsernameAndPassword(String username, String password);
	List<User> getAllUsers();
	boolean saveUser(User user);
}
