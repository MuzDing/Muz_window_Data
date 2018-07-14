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
<title>用户注册</title>
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

</head>
<body>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<dl class="admin_login">
			<dt>
				<strong>用户注册</strong> <em>User Reg</em>
			</dt>
			
			<dd class="user_icon">
				<input type="text" placeholder="用户名" class="login_txtbx" name="userName" />
			</dd>
			<dd class="pwd_icon">
				<input type="password" placeholder="密码" class="login_txtbx" name="password" />
			</dd>
			<dd class="pwd_icon">
				<input type="password" placeholder="确认密码" class="login_txtbx" name="rePassword" />
			</dd>
			<dd class="user_icon">
				<input type="text" placeholder="昵称" class="login_txtbx" name="nickName" />
			</dd>
			<dd class="user_icon">
				<input type="file" class="login_txtbx" name="imageUpload" />
			</dd>
			<dd>
				<input type="submit" value="注册" class="submit_btn" />
			</dd>
			
		</dl>
	</form>
</body>
</html>

