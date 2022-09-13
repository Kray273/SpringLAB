package com.springproj.biz.board.controller;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardService;

public class BoardRequestClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		BoardService service =(BoardService)factory.getBean("boardService");
		
		  BoardVO vo = new BoardVO(); 
		  vo.setTitle("6 번째 게시글"); 
		  vo.setWriter("euiseok");
		  vo.setContent("나는 나는 6번째 게시글입니다."); 
		  service.insertService(vo);
		
		//service.updateService(2);
		 
//		 BoardVO board = service.getService(1); 
//		 System.out.println(board);
		  
		  //글 목록 검색 기능
		List<BoardVO> list = service.getServiceList();
		System.out.println("========================");
		for(BoardVO board : list) {
			System.out.println(board);
		}
		  
		 service.deleteService(6);
		 
		factory.close();
	}

}
