<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--JSTL에서 제공하는 태그를 사용하기 위해 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>

	<center>
		<h1>글 목록</h1>
		<h3>게시판에 오신걸 환영합니다..<a href="logout.do">로그아웃</a></h3>
		<!-- 검색 시작 -->
		<!-- 검색 종류 -->
		
		<!-- 목록 출력  -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			<!-- 반복을 할 수 있도록 JSTL에서 제공하는 태그 -->
			<c:forEach items="${boardList}" var="board"> 
			<!-- 2가지의 필수요소를 가지는데 items는 data, var은 변수선언 -->
			<tr >
				<td align="center">${board.seq}</td>
				<td><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
				<td align="center">${board.writer}</td>
				<td align="center">${board.regdate}</td>
				<td align="center">${board.cnt}</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<a href="insertBoard.do" >글쓰기</a>
	</center>



</body>
</html>