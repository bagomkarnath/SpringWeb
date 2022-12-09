package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.UserDAO;
import com.spring.web.model.User;

@Service
public class UserService {
	
	private UserDAO userDao ;

	@Autowired
	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}

	public User getUserByUsernameAndPassword(String username, String password) {
		return userDao.getUserByUsernameAndPassword(username, password);
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public boolean saveUser(User user) {
		return userDao.saveUser(user);
	}
	
}
