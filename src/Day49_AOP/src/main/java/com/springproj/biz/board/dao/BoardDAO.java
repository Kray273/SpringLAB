package com.springproj.biz.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	
	
	public void insertBoaed(BoardVO vo) {
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
	//목록보기 (select문)
	public void getBoaed(int seq) {
		log.printLogging("= getBoaed() =");
		conn = JDBCUtil.getConnection();
	}
	
	public void getBoaedList() {
		log.printLogging("= getBoaedList() =");
		conn = JDBCUtil.getConnection();
	}
	
	// 수정 (update문)
	public void updateBoaed(BoardVO vo) {
		log.printLogging("= updateBoaed() =");
		conn = JDBCUtil.getConnection();
			
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
		
	}
	
	// 삭제 (delete문)
	public void deleteBoaed(int seq) {
		log.printLogging("= deleteBoaed() =");
		conn = JDBCUtil.getConnection();
		
	}
}
