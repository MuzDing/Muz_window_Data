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
	String strUserID = null;
	String strUserPWD = null;
	boolean ret;

	//从登录页面获取用户输入的账号和密码
	strUserID = request.getParameter("txtUserID").toString();
	strUserPWD = request.getParameter("txtUserPWD").toString();
	//封装用户信息
	UserBean ub = new UserBean();
	ub.setUserID(strUserID);
	ub.setUserPassWord(strUserPWD);

	//out.print(ub.getUserID() + ub.getUserPassWord());

	//调用JavaBean中的用户判断信息
	ret = userManager.UserCheck(ub);

	if (ret == true) {
		//out.print("合法用户");
		response.sendRedirect("default.jsp");
	} else {
		response.sendRedirect("error.html");
		//out.print("非法用户");
	}
%>
</body>
</html>