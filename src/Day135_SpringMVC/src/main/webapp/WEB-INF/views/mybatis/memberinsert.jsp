<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입_mybitis</title>
</head>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"/>
<script >

</script>
<h1>회원가입</h1>
<form action="<%=request.getContextPath() %>/memberinsert" method="post">
	아이디	 <input type="text" name="id" required><br>
	암호 <input type="password" name="pw" required><br>
	이름 <input type="text" name="name" required><br>
	전화번호 <input type="number" name="phone" value="010" required><br>
	이메일 <input type="email" name="email" value="sba@a.com" required><br>
	주소 <input type="text" name="address" value="서울시 용산구" required><br>
<input type="submit" value="로그인"> 
</form>

</body>
</html>