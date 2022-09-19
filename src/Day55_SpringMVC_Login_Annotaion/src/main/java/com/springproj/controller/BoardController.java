package com.springproj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springproj.biz.domain.BoardVO;
import com.springproj.biz.service.BoardService;

import oracle.security.crypto.core.SREntropySource;

@Controller //Annotation Been 생성 요청
public class BoardController {

	@Autowired
	BoardService boardService;
	
	//@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	@GetMapping("/insertBoard.do")
	public String insertBoard() {
		System.out.println("InsertBoardController 처리");

		return "insertBoard";
	}
	
	//@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	@PostMapping("/insertBoard.do")
	public String insertBoard(BoardVO board) {//매개변수의 자료형과, 갯수가 다르면 오버로딩 가능
		System.out.println("글등록 처리");

		boardService.insertService(board); //request 대신 VO를 매개변수로 설정해 받아오는 작업은 불필요.
		//VO의 변수 이름과 insert_view name의 이름이 같이야 함! 
		return "redirect:getBoardList.do";

	}
	
	
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO board, Model model){
		System.out.println("getBoardController 처리.");
		
		BoardVO vo = boardService.getService(board.getSeq());
		
		model.addAttribute("board",vo);
		
		return "getBoard";
	}
	
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(Model model){
		
		System.out.println("글 목록 검색 처리");
		
		List<BoardVO> list =boardService.getServiceList();
		
		model.addAttribute("boardList",list);
		
		return "getBoardList";
	}
	
	
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO board) {
		System.out.println("글수정 처리");
	
		boardService.updateService(board);
		
		return "redirect:getBoardList.do";
		
	}
	
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO board) {
		System.out.println("글삭제 처리");
		
		boardService.deleteService(board.getSeq());
		
		return "redirect:getBoardList.do";
		
	}

}
