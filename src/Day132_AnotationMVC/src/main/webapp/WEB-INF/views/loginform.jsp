<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼!</title>
</head>
<body>
<img alt="사진입니다." src="<%=request.getContextPath() %>/resources/images/americano.jpg">
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"/>
<script >
$(document).ready(function(){alert("성공")});
</script>
<h1>로그인폼</h1>
<form action="<%=request.getContextPath() %>/login" method="post">
	아이디	 <input type="text" name="id"><br>
	암호 <input type="password" name="pw"><br>
	나이 <input type="number" name="age"><br>
<input type="submit" value="로그인"> 
</form>
=====================================================
<h3>${all}</h3>
</body>
</html>