<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	//session.invalidate();
	session.removeAttribute("userLogin");

	int userCount = 0;
	Object object = application.getAttribute("userCount");
	if(object != null){
		userCount = Integer.valueOf(object.toString());
	}
	userCount--;
	application.setAttribute("userCount", userCount);
	
	response.sendRedirect("index.jsp");
%>
