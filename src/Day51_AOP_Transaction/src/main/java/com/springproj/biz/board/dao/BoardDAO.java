package com.springproj.biz.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springproj.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO { 
	
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content) "
			+ "values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=?, where seq=?";
	private final String BOARD_SELECT = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq";
	private final String BOARD_DELETE = "delete from board where seq=?";
	
	@Autowired //객체 주입을 요구
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		Object[] args = {vo.getTitle(),vo.getWriter(),vo.getContent()};
		jdbcTemplate.update(BOARD_INSERT,args);	
	}
	
	public BoardVO getBoard(int seq) {
		Object[] args = {seq};
		return jdbcTemplate.queryForObject(BOARD_SELECT, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList() {
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());	
	}
	
	public void updateBoard(BoardVO vo) {
		Object[] args = {vo.getTitle(),vo.getContent(),vo.getSeq()};
		jdbcTemplate.update(BOARD_UPDATE,args);	
	}
	
	public void deleteBoard(int seq) {
		jdbcTemplate.update(BOARD_DELETE, seq);			
	}
}
