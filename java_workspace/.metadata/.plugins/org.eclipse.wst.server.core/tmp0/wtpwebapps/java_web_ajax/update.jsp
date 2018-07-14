<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <script type="text/javascript" src="JS/jquery-1.4.1.min.js"></script>
<body>
输入账号：
<input type="text" id="num"><br><br>
输入密码：
<input type="text" id="password"><br><br>
<input type="button" id="btnUpdate" value="点击修改">
</body>
<script>
$(function(){
	 $("#btnUpdate").click(function(){
		
		var num=$("#num").val();
		var password=$("#password").val();
		
		if(num==""){
			alert("修改的账号不能为空！");return;
		}
		 var aj = $.ajax({

			     type: 'POST',

			     url: 'UpdateServlet' ,

			    data: {num:num,password:password},
				

			    success: function (data) {
			    	
			    	 if(data==1){
			               	alert("修改成功！");
			                }
			                if(data==2){
			                	alert("修改失败！账号不存在！");
			                }
			                   
                },
                error: function (data) {
                    alert(data);
                }
			});
	 });
});

</script>
</html>