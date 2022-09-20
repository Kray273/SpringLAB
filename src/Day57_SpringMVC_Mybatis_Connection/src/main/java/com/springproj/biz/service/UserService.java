package com.springproj.biz.service;

import java.util.List;

import com.springproj.biz.domain.UserVO;

public interface UserService {
	
	// CRUD 메서드 호출
	//  회원 등록
	//void insertUserService(UserVO user);
		
	// 회원 목록 조회
	public UserVO getService(UserVO user);
	
	//List<UserVO> getServiceList();
	
	// 회원 수정
	//void updateService(UserVO user);
	
	// 회원 탈퇴
	//void deleteService(UserVO user);

}