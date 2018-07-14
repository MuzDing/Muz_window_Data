<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			padding: 0px;
			margin: 0px;
		}
	</style>
	
	<link rel="stylesheet" type="text/css" href="css/public.css" />
	<style type="">
		.ca{
			font-size: 14px;
			padding-top: 12px;
			display: inline-block;
			color: white;
			cursor: pointer;
		}
	</style>
  </head>
  
  <body>
    <div>
    	<div id="top" style="height: 100px">
    		<div class="head">
				<div class="headL">
					<img class="headLogo" src="img/headLogo.png" />
				</div>
				<div class="headR">
					<p class="p1">
						欢迎，
						【<img src="images/user/${userLogin.usrImage}" alt="" style="height: 30px;" />${userLogin.usrNickname}】
						<a href="#" class="resetPWD ca">修改密码</a>&nbsp;&nbsp;
						<a href="user.do?action=unLogin" onclick="{if(confirm('确定退出吗')){return true;}return false;}" class="goOut ca">退出</a>
					</p>
				</div>
				<!-- onclick="{if(confirm(&quot;确定退出吗&quot;)){return true;}return false;}" -->
			</div>
    	</div>
    	<div id="left" style="width: 15%;float: left;">
    		<iframe src="left.jsp" width="100%" style="border: none;height: 580px"></iframe>
    	</div>
    	<div id="right"  style="width: 85%;float: left;">
    		<iframe name="mainIframe" src="index.jsp" width="100%" style="border: none;height: 580px"></iframe>
    	</div>
    </div>
  </body>
</html>
