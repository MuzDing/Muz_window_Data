<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>this is include1 page</h1>
	<!-- 包含include2 -->
	<jsp:include page="/include2.jsp"></jsp:include>
</body>
</html>