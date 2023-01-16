<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록결과</title>
</head>
<body>
<!-- 컨트롤러 메소드로 부터 registerresult 모델 전달 받아온다. -->
<h1>${result}</h1>
입력 아이디 : ${dto.id}<br>
입력 이름 : ${dto.name}<br>
입력 폰 : ${dto.phone}<br>
입력 이메일 : ${dto.email}<br>
</body>
</html>