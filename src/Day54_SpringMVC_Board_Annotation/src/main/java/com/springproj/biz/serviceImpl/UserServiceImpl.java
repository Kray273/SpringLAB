package com.springproj.biz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.dao.UserDAO;
import com.springproj.biz.domain.UserVO;
import com.springproj.biz.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserVO getService(UserVO user) {
		return userDAO.getUser(user);
	}

	
}
