<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="com.czu.UserManagerBean"%> 
<%@page language="java" import="com.czu.UserBean"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userManager" class="com.czu.UserManagerBean"></jsp:useBean>

<%
	boolean ret;
	String strUserID = request.getParameter("txtUserID").toString();
	String strUserPWD = request.getParameter("txtUserPWD").toString();
	UserBean ub = new UserBean();
	
	ub.setUserID(strUserID);
	ub.setUserPassWord(strUserPWD);
	ret = userManager.UserCheck(ub);
	if (ret == true) {
		response.sendRedirect("default.jsp");
	} else {
		response.sendRedirect("error.html");	
	}
%>
</body>
</html>