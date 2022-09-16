package com.springproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springproj.biz.domain.UserVO;
import com.springproj.biz.service.UserService;

@Controller
public class LogInOutController {
	
	@GetMapping("/login.me")
	public String login() {
		//System.out.println("LoginForm 호출");
		return "login";
		
	}
	
	@PostMapping("/login.me")
	public String loginProc(UserVO user) {
		//System.out.println("LoginProc 호출");
		
		//1. user의 id 존재 여부를 DB에서 가져와 확인.
		UserVO login = UserService.get;
				
		if(user != null) {
			return 
		}
		return "getBoardList";
	}
	
}
