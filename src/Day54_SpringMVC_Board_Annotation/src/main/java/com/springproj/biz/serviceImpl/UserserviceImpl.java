package com.springproj.biz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.dao.UserDAO;
import com.springproj.biz.domain.UserVO;
import com.springproj.biz.service.UserService;

@Service("UserService")
public class UserserviceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	@Override
	public UserVO getUser(UserVO user) {
		UserVO login = dao.getUser(user);
		return login;
	}

	
}
