package com.springproj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//java의main과 같은 공간 = service단을 호출해주면 된다
		
		//System.out.println("/hello.do 요청 처리 메서드()");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("greeting", "Hellow Spring");
		
		//viewResolver 는 setViewName 의 앞뒤에 접두사 접미어를 붙여 수행해야 할 jsp 파일을 호출 할 수 있게 만들어준다.
		mav.setViewName("hello");  // /WEB-INF/views/ hello.jsp"
		
		
		return mav;
	}

}
