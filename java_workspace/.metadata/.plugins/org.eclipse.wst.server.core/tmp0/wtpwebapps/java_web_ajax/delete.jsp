<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
 <script type="text/javascript" src="JS/jquery-1.4.1.min.js"></script>
<body>请输入需要删除的账号：
<input type="text" id="num">
<input type="button" id="Delete" value="删除">
</body>
<script>
$(function(){
	 $("#Delete").click(function(){
		 
		var num=$("#num").val();
		if(num==""){
			alert("要删除的账号不能为空！请重新输入！");return;
		}
		 var aj = $.ajax({

		     type: 'POST',

		     url: 'DeleteServlet' ,
		     traditional: true,
		    data: {num:num},

		    success: function (data) {
                if(data==1){
               	alert("删除成功！");
                }
                if(data==2){
                	alert("删除失败！该账号不存在！");
                }
                   
                  
               },
               error: function (data) {
                   alert("系统内部错误！请联系管理员！");
               }


		  

		});
	 });
	
	
});
</script>
</html>