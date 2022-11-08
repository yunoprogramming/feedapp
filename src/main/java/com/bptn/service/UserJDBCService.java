package com.bptn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.bean.UserID;
import com.bptn.dao.UserDao;

@Service
public class UserJDBCService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserDao userDao;

	public List<UserID> listUsers(){

		List<UserID> users = userDao.listUsers();

		users.forEach(u -> logger.debug("{}",u));

		return users;
	}

	public UserID findUser(String username){
		
		UserID user = userDao.findByUsername(username);

		logger.debug("{}",user);
		
		return user;
	}

	public void createUser(UserID user){
		
		this.userDao.createUser(user);

		logger.debug("User Created: {}",user);		
	}
}
