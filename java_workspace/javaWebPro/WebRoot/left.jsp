<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页左侧导航</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<head></head>

<body id="bg">
	<c:if test="${userList == null}">
  		<c:redirect url="user.do?action=queryUserList&pageIndex=1"></c:redirect>
  	</c:if>

	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			<a href="main.jsp" target="main"><div class="line">
					<img src="img/coin01.png" />&nbsp;&nbsp;首页
				</div> </a>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coinL1.png" /><img class="icon2"
						src="img/coinL2.png" /> 系统管理<img class="icon3"
						src="img/coin19.png" /><img class="icon4" src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="index.jsp" target="mainIframe"
						class="cks">用户管理</a><img class="icon5" src="img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="changepwd.html" target="mainIframe"
						class="cks">修改密码</a><img class="icon5" src="img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a class="cks">退出</a><img class="icon5"
						src="img/coin21.png" />
				</dd>
			</dl>

		</div>

	</div>
</body>
</html>

