package com.springproj.biz.board.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao; 
	
	@Override
	public void insertService(BoardVO vo) {
	
		  
		  //강제 예외발생
//		  if(vo.getSeq() == 0) { throw new
//		  IllegalArgumentException("0번 글은 등록할 수 없습니다."); }
			 
		  dao.insertBoard(vo);
	}

	@Override
	public BoardVO getService(int seq) {
		BoardVO board = dao.getBoard(seq);
		
		return board;
		
	}

	@Override
	public List<BoardVO> getServiceList() {
		return dao.getBoardList();
		
	}

	@Override
	public void updateService(BoardVO vo) {
		dao.updateBoard(vo);
		
	}

	@Override
	public void deleteService(int seq) {
		dao.deleteBoard(seq);
	}

}
