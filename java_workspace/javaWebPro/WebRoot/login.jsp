<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>网站登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<style>
body {
	height: 100%;
	background: #16a085;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/Particleground.js"></script>
<script>
	$(document).ready(function() {
		//粒子背景特效
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});
	});
</script>

<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String type = request.getParameter("type");
	pageContext.setAttribute("type", type);

	Cookie[] cks = request.getCookies();
	Map<String, String> map = new HashMap<String, String>();
	map.put("userNameCookie", "");
	map.put("passwordCookie", "");
	if (cks != null) {
		for (int i = 0; i < cks.length; i++) {
			Cookie c = cks[i];
			map.put(c.getName(), c.getValue());
		}
	}
%>
</head>
<body>
	<form action="user.do?action=login" method="post">
		<dl class="admin_login">
			<dt>
				<strong>系统登录</strong> <em>System Login</em>
			</dt>
			<c:if test="${type eq -1}">
				<dd>
					<span style="color: red;">用户名或密码错误</span>
				</dd>
			</c:if>
			<c:if test="${type eq 0}">
				<dd>
					<span style="color: red;">用户未启用，请联系管理员进行启用</span>
				</dd>
			</c:if>
			<dd class="user_icon">
				<input type="text" placeholder="账号" class="login_txtbx"
					name="userName" value="<%=map.get("userNameCookie")%>" />
			</dd>
			<dd class="pwd_icon">
				<input type="password" placeholder="密码" class="login_txtbx"
					name="password" value="<%=map.get("passwordCookie")%>" />
			</dd>
			<dd>
				<input type="submit" value="立即登录" class="submit_btn" />
			</dd>
			<dd style="height: 22px;text-align: right;">
				<a href="reg.jsp">新用户注册</a>
			</dd>
		</dl>
	</form>
</body>
</html>

