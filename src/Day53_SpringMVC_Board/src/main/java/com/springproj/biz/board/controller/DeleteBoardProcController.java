package com.springproj.biz.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardService;

public class DeleteBoardProcController implements Controller {
	@Autowired
	BoardService boardService;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글삭제 처리");
	
		String seq = request.getParameter("seq");
		
		boardService.deleteService(Integer.parseInt(seq));
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
		
	}

}
