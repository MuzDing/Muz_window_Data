<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	aaaaaaaaaaaaaaaaaaaaaaaaaaaaa

	<%
		int i=10;
		out.write("bbbbbbbbbbbbbbb");
		response.getWriter().write("cccccccccccccc");
	%>
	<%="dddddddddddddddddd" %>
	
	<%
		System.out.print(i);
	%>
	
</body>
</html>