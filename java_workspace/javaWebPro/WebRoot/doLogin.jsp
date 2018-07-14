<%@page import="com.entity.SysUser"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.dao.UserDaoImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	  
	//设置session失效时间，单位秒
    //session.setMaxInactiveInterval(5);
	
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	int type = -1;//-1:用户名或密码错误,0:用户已存在,1:正常
	
	UserDao ud = new UserDaoImpl();
	SysUser u = ud.login(userName, password);
	if(u != null){
		type = 1;
		session.setAttribute("userLogin", u);
		int userCount = 0;
    	Object object = application.getAttribute("userCount");
    	if(object != null){
    		userCount = Integer.valueOf(object.toString());
    	}
    	userCount++;
    	application.setAttribute("userCount", userCount);
    	
    	Cookie ck = new Cookie("userNameCookie",userName);
    	//设置实效时间,单位秒
    	ck.setMaxAge(5);
    	Cookie ck2 = new Cookie("passwordCookie",password);
    	ck2.setMaxAge(5);
    	
    	response.addCookie(ck);
    	response.addCookie(ck2);
    	
		response.sendRedirect("index.jsp");
	}else{
		type = -1;
		response.sendRedirect("login.jsp?type="+type);
	}
%>
