package com.springproj.biz.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao; 
	
	//private Log4jAdvice log; AOP적용으로 불필요	
	
	@Override
	public void insertService(BoardVO vo) {
		  //log.printLogging("= insertService() ="); AOP적용으로 불필요
		  
		  //강제 예외발생
//		  if(vo.getSeq() == 0) { throw new
//		  IllegalArgumentException("0번 글은 등록할 수 없습니다."); }
			 
		  dao.insertBoard(vo);
	}

	@Override
	public BoardVO getService(int seq) {
		BoardVO board = dao.getBoard(seq);
		
		return board;
		//log.printLogging("= getService() ="); AOP적용으로 불필요
	}

	@Override
	public void getServiceList() {
		dao.getBoardList();
		//log.printLogging("= getServiceList() =");AOP적용으로 불필요
	}

	@Override
	public void updateService(BoardVO vo) {
		dao.updateBoard(vo);
		//log.printLogging("= updateService() =");AOP적용으로 불필요
		
	}

	@Override
	public void deleteService(int seq) {
		dao.deleteBoard(seq);
		//log.printLogging("= deleteService() =");AOP적용으로 불필요
	}

}
