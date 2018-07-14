<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="CSS/add.css" type="text/css">
<body>
	<form action="add" method="post">
		<h2>学生信息添加</h2>
		姓名：<input type="text" name="name"><br>
		<br> 账号：<input type="text" name="num"><br>
		<br> 密码 ：<input type="text" name="password"><br>
		<br> 年龄：<input type="text" name="age"><br>
		<br> 性别：<input type="radio" name="sex" checked="checked"
			value="男">男<input type="radio" name="sex" value="女">女<br>
		<br> 爱好：<input type="checkbox" name="hobby" value="音乐">音乐<input
			type="checkbox" name="hobby" value="阅读">阅读 <input
			type="checkbox" name="hobby" value="运动">运动<br>
		<br> 生源地：<select name="sheng">
			<option value="江苏">江苏
			<option value="安徽">安徽
			<option value="湖南">湖南
		</select> <select name="shi">
			<option value="常州市">常州市
			<option value="合肥市">合肥市
			<option value="长沙市">长沙市
		</select><br>
		<br> <input type="submit" value="提交"> <input type="reset"
			value="重置">
	</form>
</body>
</html>