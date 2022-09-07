package com.springproj.biz.board.service;


import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.dao.BoardDAO;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO dao; //필드에서 선언해서 중복을 제거. 
	
	public BoardServiceImpl() {
		dao = new BoardDAO(); // 기능을 활용하기 위해 생성자를 사용
	}
	//annotation으로 대체 가능
	
	@Override
	public void insertService(BoardVO vo) {
		  dao.insertBoaed(vo);
	}

	@Override
	public void getService(int seq) {
		dao.getBoaed(seq);
	}

	@Override
	public void getServiceList() {
		dao.getBoaedList();
	}

	@Override
	public void updateService(BoardVO vo) {
		dao.updateBoaed(vo);
		
	}

	@Override
	public void deleteService(int seq) {
		dao.deleteBoaed(seq);
	}

	

}
