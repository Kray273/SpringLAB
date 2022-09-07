package com.springproj.biz.board.controller;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardServiceImpl;

public class BoardRequestClient {

	public static void main(String[] args) {
		
		BoardServiceImpl service = new BoardServiceImpl(); 
		BoardVO vo = new BoardVO();
		//매서드를 사용하려면 객체부터 만들어 준다
		
		vo.setTitle("첫 번째 게시글");
		vo.setWriter("euiseok");
		vo.setContent("나는 나는 첫 번째 게시글입니다.");
		
		service.insertService(vo);
	}

}
