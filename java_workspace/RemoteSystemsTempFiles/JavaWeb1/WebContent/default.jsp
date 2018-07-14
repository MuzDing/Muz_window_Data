<%@page import="com.czu.StudentBean"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	Date date = new Date();
	SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	String today=df.format(date);

%>
当前时间：<%=today%> 
<form action="studentCheck.jsp">
<br><h3>输入学生ID：</h3><br>
<input type="text" name="StuID">
<input type="submit" value="查询">
</form>


</body>
</html>