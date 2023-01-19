<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일리스트</title>
</head>
<body>
<h1>다운로드 목록을 보여드립니다.</h1>
<% 
	String[] filelist = (String[])request.getAttribute("filelist");
	for(String filename : filelist){
		out.println("<h6><a href='filedownload?onefile=" + filename + "'>"
		+filename + "</a></h3>");
	}
%>

</body>
</html>