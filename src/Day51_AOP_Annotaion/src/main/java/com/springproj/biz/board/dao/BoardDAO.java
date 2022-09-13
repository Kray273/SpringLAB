package com.springproj.biz.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.common.JDBCUtil;
import com.springproj.biz.common.Log4jAdvice;

@Repository("boardDAO")
public class BoardDAO { //DAO_Data Access Object
	
	@Autowired
	//private LogAdvice log;
	private Log4jAdvice log;
	
	Connection conn;

	PreparedStatement pstmt;
	
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content) "
			+ "values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=?, where seq=?";
	private final String BOARD_SELECT = "select * from board where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	
	
	
	public void insertBoard(BoardVO vo) {
		log.printLogging("= insertBoaed() =");
		conn = JDBCUtil.getConnection();
		
		pstmt = null;
		
		try {
			 pstmt = conn.prepareStatement(BOARD_INSERT); 
			 pstmt.setString(1, vo.getTitle());
			 pstmt.setString(2, vo.getWriter());
			 pstmt.setString(3, vo.getContent());
			 
			 int result = pstmt.executeUpdate(); 
			 
			 if(result == 1 ) {
				 System.out.println("===> 데이터 저장 성공");
			 } else {
				 System.out.println("===> 데이터 저장 실패");				 
			 } 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally { 
			JDBCUtil.close(pstmt, conn);
		}
		
		
	}
	

	public BoardVO getBoard(int seq) {
		log.printLogging("= getBoaed() =");
		
		conn = JDBCUtil.getConnection();
		pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = conn.prepareStatement(BOARD_SELECT); 
			 pstmt.setInt(1, seq);
			 
			 rs = pstmt.executeQuery(); 
			 
			 if(rs.next()) {
				 BoardVO board = new BoardVO();
				 
				 board.setSeq(rs.getInt("seq"));
				 board.setTitle(rs.getString("title"));
				 board.setWriter(rs.getString("writer"));
				 board.setContent(rs.getString("content"));
				 board.setRegdate(rs.getDate("regdate"));
				 board.setCnt(rs.getInt("cnt"));
				 
				 return board;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally { 
			JDBCUtil.close(rs,pstmt, conn);
		}
		
		return null;

	}
	
	public void getBoardList() {
		log.printLogging("= getBoaedList() =");
		conn = JDBCUtil.getConnection();
	}
	

	public void updateBoard(BoardVO vo) {
		log.printLogging("= updateBoaed() =");
		conn = JDBCUtil.getConnection();
		pstmt = null;
		try {
			 pstmt = conn.prepareStatement(BOARD_UPDATE); 
			 pstmt.setString(1, vo.getTitle());
			 pstmt.setString(2, vo.getContent());
			 pstmt.setInt(3, vo.getSeq());
			 
			 int result = pstmt.executeUpdate(); 
			 
			 if(result == 1 ) {
				 System.out.println("===> 데이터 수정 성공");
			 } else {
				 System.out.println("===> 데이터 수정 실패");				 
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally { 
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	
	
	public void deleteBoard(int seq) {
		log.printLogging("= deleteBoaed() =");
		conn = JDBCUtil.getConnection();
		pstmt = null;
		try {
			 pstmt = conn.prepareStatement(BOARD_DELETE); 
			 pstmt.setInt(1, seq);
			 
			 int result = pstmt.executeUpdate(); 
			 
			 if(result == 1 ) {
				 System.out.println("===> 데이터 삭제 성공");
			 } else {
				 System.out.println("===> 데이터 삭제 실패");				 
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally { 
			JDBCUtil.close(pstmt, conn);
		}
		
		
	}
}
