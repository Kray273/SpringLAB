package com.springproj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproj.biz.domain.UserVO;
import com.springproj.biz.service.UserService;

@Controller
public class LogInOutController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login.me")
	public String login(@ModelAttribute("usr") UserVO vo) { //변수 앞에 설정하면 이름을 원하는대로 사용 할 수 있다.
		//System.out.println("LoginForm 호출");
		
		vo.setId("1");
		vo.setPassword("1");
		return "login";
		
	}
	
	@PostMapping("/login.me")
	public String loginProc(UserVO user, HttpSession session) {
		//강제 오류발생
		if(user.getId() == null || user.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		
		String retVal = null;
		
		UserVO vo = userService.getService(user);
				
		if((vo != null) && vo.getPassword().equals(user.getPassword()) ) {
			
			session.setAttribute("userName", vo.getName());
			
			retVal = "redirect:getBoardList.do";
		} else {
			retVal = "redirect:login.me";
		}
		
		return retVal;
	}
	
	@RequestMapping("/logout.me")
	public String logoutProc(HttpSession session)  {
		//System.out.println("로그 아웃 처리");
		
		//session 삭제
		session.invalidate();
		
		return "redirect:login.me";
	}
	
}
