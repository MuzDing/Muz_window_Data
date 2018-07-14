<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	please input two number:
	<br> num1：
	<input type="text" id="num1">
	<br>
	<br> num2：
	<input type="text" id="num2">
	<br>
	<br>

	<input type="button" onclick="compareTo()" value="开始"></input>
	<br>
	<br> max：
	<input type="text" id="num3">
	<br>
	<br> min：
	<input type="text" id="num4">

	<%
		String week = (String) request.getAttribute("week");
	%>
<body>

	<form action="dateServlet" method="post">
		请输入数字： <input type="text" name="num"> <input type="submit"
			value="查询">
	</form>
	<%
		if (week != null) {
			out.print(week);
		}
	%>


</body>

<script>
	function compareTo() {
		var num1 = document.getElementById("num1").value;
		var num2 = document.getElementById("num2").value;
		if (num1 > num2) {
			document.getElementById("num3").value = num1;
			document.getElementById("num4").value = num2;
		}
		if (num1 < num2) {
			document.getElementById("num3").value = num2;
			document.getElementById("num4").value = num1;
		}
		if (num1 == num2) {
			alert("两个数字相等！");
		}
	}
</script>

</html>