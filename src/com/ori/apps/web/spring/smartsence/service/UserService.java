package com.ori.apps.web.spring.smartsence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ori.apps.web.spring.smartsence.dao.User;
import com.ori.apps.web.spring.smartsence.dao.UsersDAO;

@Service("userService")
public class UserService {
	
	private UsersDAO usersDao;
	
	@Autowired
	public void setUsersDao(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}

	public void createUser(User user) {
		usersDao.create(user);		
	}

	public boolean exist(String username) {
		
		return usersDao.exist(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}	

}
