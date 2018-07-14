<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript">

	function isExist(){
		
		var num = document.getElementById("txtUserID").value;
		var passwd = document.getElementById("txtUserPWD").value;

		if (1 == num && 2 ==passwd){
			window.location.href="first.html"
		}else{
			window.location.href="error.html"
		}
	}
	
</script>
</head>
<body>
	账号：<input type="text" id="txtUserID">
	<br><br>
	密码：<input type="text" id="txtUserPWD">
	<br><br>
	<input type="submit" name="btnOK" value="提交" onclick="isExist()">
</form>
</body>
</html>