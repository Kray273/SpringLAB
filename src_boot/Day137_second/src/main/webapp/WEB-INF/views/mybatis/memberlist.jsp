<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybatis.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memberlist_MVC</title>
</head>
<body>
<h1>전체 회원 정보를 가져옵니다.</h1>
<h6>url : mybatismemberlist</h6>
<% 
	List<MemberDTO> memberlist = (List<MemberDTO>)request.getAttribute("memberlist");
	for(MemberDTO m : memberlist){ %>
	<h6><%=m.getId()%> : <%=m.getPw()%> : <%=m.getName()%> : <%=m.getAddress()%></h6>
	<% } %>

</body>
</html>