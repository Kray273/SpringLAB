package com.springproj.biz.service;

import java.util.List;

import com.springproj.biz.domain.BoardVO;
import com.springproj.biz.domain.UserVO;

public interface UserService {
	// CRUD 기능 수행을 위한 메서드 호출 기능

	// 회원 조회
	UserVO getUser(UserVO user);
	
}