<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户登录</title>
</head>
<body>
<form action="userCheck.jsp" method="post">
账号：<input type="text" name="txtUserID">（2）
<br><br>
密码：<input type="text" name="txtUserPWD">（2）
<br><br>
<input type="submit" name="btnOK" value="提交">
</form>
</body>
</html>