package com.library.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.library.entity.User;
import com.library.model.persistence.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User loginUser(User user) {
		
		return userDao.getUserByIdAndPassword(user.getId(), user.getPassword());
	}
}
