package com.springproj.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springproj.biz.domain.BoardVO;

@Repository("boardDAO")
public class BoardDAO extends SqlSessionDaoSupport{ // DAO (Data Access Object)

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		//super는 상속의 관계하에서 부모의 method호출
	}
	
	//@Autowired Mybatis로 처리
	//private JdbcTemplate jdbcTemplate;

	// 글 등록(insert문)
	public void insertBoard(BoardVO vo) {
		getSqlSession().insert("Board.insertBoard", vo);	
	}

	// 목록보기(select문)
	public BoardVO getBoard(int seq) {
		return getSqlSession().selectOne("Board.getBoard", seq);	
	}

	public List<BoardVO> getBoardList(BoardVO vo) {

		if(vo.getSearchCondition().equals("TITLE")) {	
			return getSqlSession().selectList("Board.getBoardList_T", vo);
		} else if(vo.getSearchCondition().equals("CONTENT")) {
			return getSqlSession().selectList("Board.getBoardList_C", vo);
		} else {
			return getSqlSession().selectList("Board.getBoardList_T",vo);	
		}
		
	}

	// 글 수정(update문)
	public void updateBoard(BoardVO vo) {
		getSqlSession().update("Board.updateBoard", vo);	
		
	}

	// 글 삭제(delete문)
	public void deleteBoard(int seq) {
		getSqlSession().delete("Board.deleteBoard", seq);	
	}
	
	// 조회수 증가
	public void cutUp(BoardVO vo) {
		getSqlSession().update("Board.cutUp",vo);	
	}

	//mybatis사용으로 불필요	
    //class BoardRowMapper implements RowMapper<BoardVO>{
//
//		@Override
//		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//			// TODO Auto-generated method stub
//			
//			BoardVO board = new BoardVO();
//			board.setSeq(rs.getInt("seq"));
//			board.setTitle(rs.getString("Title"));
//			board.setWriter(rs.getString("Writer"));
//			board.setContent(rs.getString("content"));
//			board.setRegdate(rs.getDate("regdate"));
//			board.setCnt(rs.getInt("cnt"));
//			
//			return board;
//		}

	//}

}
