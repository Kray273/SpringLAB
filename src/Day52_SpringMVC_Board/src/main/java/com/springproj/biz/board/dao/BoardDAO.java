package com.springproj.biz.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springproj.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO { // DAO (Data Access Object)

	// CRUD (Create Read Update Delete) 기능의 메서드 구현
	
	/*
	private final String BOARD_INSERT = "INSERT into board(seq, title, writer, content) values("
			+ "(select nvl(max(seq),0)+1 from board),?,?,?)";
	*/
	private final String BOARD_INSERT = "INSERT into board(seq, title, writer, content) values("
			+ "?,?,?,?)";
	
	private final String BOARD_UPDATE = "UPDATE board set title= ?, content = ? WHERE seq = ?";

	private final String BOARD_DELETE = "DELETE FROM board  WHERE seq = ?";

	private final String BOARD_GET = "SELECT * FROM board  WHERE seq = ?";

	private final String BOARD_GETLIST = "SELECT * FROM board  ORDER BY seq ASC";

	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	// 글 등록(insert문)
	public void insertBoard(BoardVO vo) {
		//Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		Object[] args = {vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()};
		
		jdbcTemplate.update(BOARD_INSERT, args);
		
	
		
	}

	// 목록보기(select문)
	public BoardVO getBoard(int seq) {
		Object[] args = {seq};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
				
	}

	
	
	
	
	
	
	
	public List<BoardVO> getBoardList() {

		
		return jdbcTemplate.query(BOARD_GETLIST, new BoardRowMapper());
		

	}

	// 글 수정(update문)
	public void updateBoard(BoardVO vo) {
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		jdbcTemplate.update(BOARD_UPDATE, args);
		
		
		
	}

	// 글 삭제(delete문)
	public void deleteBoard(int seq) {
		
		jdbcTemplate.update(BOARD_DELETE, seq);
		
	}

}
