<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
</head>
<body>
<h1> 5명을 출력해보자!</h1>
<h5>${model[0]}</h5>
<h5>${model[1]}</h5>
<h5>${model[2]}</h5>
<h5>${model[3]}</h5>
<h5>${model[4]}</h5>

<c:forEach items="${model}" var="names">
<h5>${names}</h5>
</c:forEach>

</body>
</html>