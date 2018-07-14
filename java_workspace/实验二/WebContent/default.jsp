<%@page import="com.czu.StudentBean"%>

<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" import="com.czu.UserBean"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	StudentBean stu=(StudentBean)request.getAttribute("stu");
%> 
<form action="studentCheck.jsp">
<br><h3>输入学生ID：</h3>(111)<br>
<input type="text" name="StuID">
<input type="submit" value="查询">
</form>
<%if(stu!=null){
	%>
	
	<h3>姓名：${stu.name}<br>
	性别：${stu.sex}</h3>
	<%}
%>
</body>
</html>