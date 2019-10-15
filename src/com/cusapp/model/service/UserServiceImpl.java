package com.cusapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusapp.model.persistence.User;
import com.cusapp.model.persistence.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	



	@Override
	public User findUser(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.findUser(email, password);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDao.getAllUsers();
	}

}
