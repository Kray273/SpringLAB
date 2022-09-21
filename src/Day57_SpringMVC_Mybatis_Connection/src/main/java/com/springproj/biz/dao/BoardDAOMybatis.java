package com.springproj.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springproj.biz.domain.BoardVO;

@Repository
public class BoardDAOMybatis { 
	@Autowired
	SqlSessionTemplate mybatis;
	
	// 글 등록(insert문)
	public void insertBoard(BoardVO vo) {
		mybatis.insert("Board.insertBoard", vo);	
	}

	// 목록보기(select문)
	public BoardVO getBoard(int seq) {
		return mybatis.selectOne("Board.getBoard", seq);	
	}

	public List<BoardVO> getBoardList(BoardVO vo) {

//		if(vo.getSearchCondition().equals("TITLE")) {	
//			return mybatis.selectList("Board.getBoardList_T", vo);
//		} else if(vo.getSearchCondition().equals("CONTENT")) {
//			return mybatis.selectList("Board.getBoardList_C", vo);
//		} else {
//			return mybatis.selectList("Board.getBoardList_T",vo);	
//		}
		return mybatis.selectList("Board.getBoardList",vo);	
	}

	// 글 수정(update문)
	public void updateBoard(BoardVO vo) {
		mybatis.update("Board.updateBoard", vo);	
		
	}

	// 글 삭제(delete문)
	public void deleteBoard(int seq) {
		mybatis.delete("Board.deleteBoard", seq);	
	}
	
	// 조회수 증가
	public void cutUp(BoardVO vo) {
		mybatis.update("Board.cutUp",vo);
	}


}
