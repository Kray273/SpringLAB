package com.springproj.biz.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.common.JDBCUtil;

public class BoardDAO { //DAO_Data Access Object
	
	//CRUD의 method 구현
	
	Connection conn;//변수 설정 시 null을 안쓰는 이유는 전역변수 이기에.
	
	//반복을 줄이기 위해 매서드로 실행
	PreparedStatement pstmt; //계속 사용될 변수이고 위와 같은 이유로 필드에 선언.
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content) "
			+ "values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=?, where seq=?";
	
	
	// 등록 (insert문)
	public void insertBoaed(BoardVO vo) {
		// 1. 연결
		
		/* 매서드로 반복적인 실행을 줄이기
		 * //Connection conn = null
		 * try { Class.forName("oracle.jdbc.driver.OrcleDriver"); //mysql등 자신들의 DB사에서
		 * 위치를 제공하고 있으니 Maven(porn에 추가). //예외 처리도 해줘야 한다. 던진다는 것은 main에서 처리한다는 의미이다.
		 * 
		 * //Connection conn =
		 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott",
		 * "tiger"); //이름에 ":" 가 들어가는 이름은 오라클에서 고정해놔서 이다. //"위치", "ID", "Password"순으로 나열
		 * //예외 처리 해줘야 함. but...
		 * 
		 * conn =
		 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott",
		 * "tiger"); // try문에서만 작동하기 때문에 전역변수로 필드에서 변수 설정해서 담아줌. } catch
		 * (ClassNotFoundException | SQLException e) { e.printStackTrace(); return;
		 * //안정적인 구동을 위해 }
		 */
		
		conn = JDBCUtil.getConnection();
		//매서드로 연결 부분을 한줄로 실행.	효율적인 코드 진행, 자료형은 필드에 선언
		
		// 2. jdbc를 이용해 sql처리
		
		pstmt = null;
		//PreparedStatement pstmt = null;
		try {
			 pstmt = conn.prepareStatement(BOARD_INSERT); //sql문을 편하게 관리하기 위해 필드에서 작성
			 pstmt.setString(1, vo.getTitle());
			 pstmt.setString(2, vo.getWriter());
			 pstmt.setString(3, vo.getContent());
			 
			 int result = pstmt.executeUpdate(); //결과 값을 확인하기 위해
			 
			 if(result == 1 ) {
				 System.out.println("===> 데이터 저장 성공");
			 } else {
				 System.out.println("===> 데이터 저장 실패");				 
			 } 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally { 
			/* 반복으로 인한 코드는 매서드로 구현
			 * if(pstmt != null) {//DB연결을 닫아준다. 역순 try { pstmt.close(); } catch
			 * (SQLException e) { e.printStackTrace(); } } if(conn != null) {//DB연결을 닫아준다.
			 * try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
			 */
			JDBCUtil.close(pstmt, conn);
		}
		
		
	}
	//목록보기 (select문)
	public void getBoaed(int seq) {
		conn = JDBCUtil.getConnection();
	}
	
	public void getBoaedList() {
		conn = JDBCUtil.getConnection();
	}
	
	// 수정 (update문)
	public void updateBoaed(BoardVO vo) {
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
		conn = JDBCUtil.getConnection();
		
	}
}
