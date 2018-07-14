<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
<script type="text/javascript">


	function fn1(){
		//get异步访问
		$.get(
			"/web22/ajax2", //url地址
			{"name":"张三","age":25}, //请求参数
			function(data){ //执行成功后的回调函数
				//{\"name\":\"tom\",\"age\":21}
				alert(data.name);
			},
			"json"
		);
	}
	function fn2(){
		//post异步访问
		$.post(
			"/web22/ajax2", //url地址
			{"name":"李四","age":25}, //请求参数
			function(data){ //执行成功后的回调函数
				alert(data.name);
			},
			"json"
		);
	}
	function fn3(){
		$.ajax({
			url:"/web22/ajax2",
			async:true,
			type:"POST",
			data:{"name":"lucy","age":18},
			success:function(data){
				alert(data.name);
			},
			error:function(){
				alert("请求失败");
			},
			dataType:"json"
		});
	}
</script>
</head>
<body>
	<input type="button" value="get访问服务器端" onclick="fn1()"><span id="span1"></span>
	<br>
	<input type="button" value="post访问服务器端" onclick="fn2()"><span id="span2"></span>
	<br>
	<input type="button" value="ajax访问服务器端" onclick="fn3()"><span id="span2"></span>
	<br>
</body>
</html>