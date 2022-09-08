package com.springproj.biz.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardService;

public class BoardRequestClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		BoardService service =(BoardService)factory.getBean("boardService");
		
		//BoardServiceImpl service = new BoardServiceImpl(); Spring 이용
		BoardVO vo = new BoardVO();
	
		
		vo.setTitle("첫 번째 게시글");
		vo.setWriter("euiseok");
		vo.setContent("나는 나는 첫 번째 게시글입니다.");
		
		service.insertService(vo);
		
		factory.close();
	}

}
