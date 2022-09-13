package com.springproj.biz.board.service;

import java.util.List;

import com.springproj.biz.board.BoardVO;

public interface BoardService {
	// CRUD기능을 수행을 위한 메서드 호출기능
	// 등록
	void insertService(BoardVO vo);
	// 목록 조회
	BoardVO getService(int seq);
	List<BoardVO> getServiceList();
	// 수정
	void updateService(BoardVO vo);
	// 삭제
	void deleteService(int seq);
}
