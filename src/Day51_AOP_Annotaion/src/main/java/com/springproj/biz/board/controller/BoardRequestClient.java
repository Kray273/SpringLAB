package com.springproj.biz.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardService;

public class BoardRequestClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		BoardService service =(BoardService)factory.getBean("boardService");
		
		//삽입
//		  BoardVO vo = new BoardVO(); 
//		  vo.setTitle("첫 번째 게시글"); 
//		  vo.setWriter("euiseok");
//		  vo.setContent("나는 나는 첫 번째 게시글입니다."); 
//		  service.insertService(vo);
		 
		
		//List 불러오기
		
//		  BoardVO board = service.getService(4); 
//		  System.out.println(board);
//		 
		
		//강제로 예외처리 실행
//		  BoardVO vo = new BoardVO(); 
//		  service.insertService(vo);
		
		//Around 실습
		  BoardVO vo = new BoardVO(); 
		  vo.setTitle("n 번째 게시글"); 
		  vo.setWriter("euiseok");
		  vo.setContent("나는 나는 n 번째 게시글입니다."); 
		  service.insertService(vo);
		 
		  BoardVO board = service.getService(4); 
		  System.out.println(board);
		 
		
		
		factory.close();
	}

}
