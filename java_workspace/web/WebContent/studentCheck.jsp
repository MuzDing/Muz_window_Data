<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page language="java" import="com.czu.StudentBean"%>
<%@page language="java" import="com.czu.StudentManageBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<jsp:useBean id="Stu" class="com.czu.StudentBean" scope="page"></jsp:useBean>
<jsp:useBean id="StudentManage" class="com.czu.StudentManageBean"></jsp:useBean>
<%
	
	String ID=request.getParameter("StuID").toString();
	boolean bool=true;
	bool=StudentManage.checkById(ID);
	if(bool){
		Stu=StudentManage.getInfoById();
		request.setAttribute("stu", Stu);	
		request.getRequestDispatcher("default.jsp").forward(request, response);
	}else{
		out.write("无效的ID!");
	}
%>
</body>
</html>