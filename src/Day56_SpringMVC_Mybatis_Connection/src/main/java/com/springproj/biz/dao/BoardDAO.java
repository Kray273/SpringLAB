package com.springproj.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springproj.biz.domain.BoardVO;

@Repository("boardDAO")
public class BoardDAO { // DAO (Data Access Object)

	// CRUD (Create Read Update Delete) 기능의 메서드 구현
	private final String BOARD_INSERT = "INSERT into board(seq, title, writer, content) values("
			+ "(select nvl(max(seq),0)+1 from board),?,?,?)";
	
	private final String BOARD_UPDATE = "UPDATE board set title= ?, content = ? WHERE seq = ? ";

	private final String BOARD_DELETE = "DELETE FROM board  WHERE seq = ?";

	private final String BOARD_GET = "SELECT * FROM board  WHERE seq = ?";

	//private final String BOARD_GETLIST = "SELECT * FROM board  ORDER BY seq ASC";
	//private final String BOARD_GETLIST = "SELECT * FROM board  ORDER BY seq DESC";
	
	private final String BOARD_CUNUP = "UPDATE board SET cnt=? WHERE seq = ?";
	
	//검색 기능 추가
	private final String BOARD_GETLIST_T = "SELECT * FROM board WHERE title LIKE '%'||?||'%' ORDER BY seq desc ";
	private final String BOARD_GETLIST_C = "SELECT * FROM board WHERE content LIKE '%'||?||'%' ORDER BY seq desc ";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	// 글 등록(insert문)
	public void insertBoard(BoardVO vo) {
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(BOARD_INSERT, args);
		
	}

	// 목록보기(select문)
	public BoardVO getBoard(int seq) {
		Object[] args = {seq};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
				
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		
		//return jdbcTemplate.query(BOARD_GETLIST, new BoardRowMapper());
		
		//쿼리문의 ?를 해결하기 위함
		Object[] args = {vo.getSearchKeyword()};
		
		if(vo.getSearchCondition().equals("TITLE")) {	
			 return jdbcTemplate.query(BOARD_GETLIST_T, args, new BoardRowMapper());
		} else if(vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_GETLIST_C, args, new BoardRowMapper());
		}
		
		return null;
		
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
	
	// 조회수 증가
	public void cutUp(BoardVO vo) {
		Object[] args = {vo.getCnt(), vo.getSeq()};
		jdbcTemplate.update(BOARD_CUNUP, args);
	}
	
	class BoardRowMapper implements RowMapper<BoardVO>{

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("Title"));
			board.setWriter(rs.getString("Writer"));
			board.setContent(rs.getString("content"));
			board.setRegdate(rs.getDate("regdate"));
			board.setCnt(rs.getInt("cnt"));
			
			return board;
		}

	}

}
