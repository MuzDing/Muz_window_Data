<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>记录查询</title>
 <script type="text/javascript" src="JS/jquery-1.4.1.min.js"></script>
</head>
<body>
请输入账号：
<input type="text" id="num">
<input type="button" id="btnSelect" value="点击查询">

<table cellspacing="0" border="1" id="table-result" style="border-collapse:collapse;">  
       <thead id="title"></thead> 
       
        <tbody id="tbody-result"> 
   
        </tbody>  
    </table>  
</body>
<script>
$(function(){
	 $("#btnSelect").click(function(){
		
		var num=$("#num").val();
		
		
		if(num==""){
			alert("查询账号不能为空！");return;
		}
		 var aj = $.ajax({

			     type: 'POST',

			     url: 'SelectByNum' ,

			    data: {num:num},
				
			  

			    success: function (data) {
			    	if(data=="{user:[]}"){
			    		alert("不存在相关账号的信息！");return;
			    	}
			    	var dataobj = eval("(" + data + ")"); //转换为json对象
			    	
                    var strTableHtml = "";
                    var strTableHtml1 = "   <tr>   <th>姓名</th>  <th>账号</th>   <th>密码</th>  <th>年龄</th> <th>性别</th>    <th>爱好</th> <th>省</th>  <th>市</th> </tr>   ";
                    //遍历查询到的列表
                    $.each(dataobj.user, function (i, item) {    
                    	
                        strTableHtml = strTableHtml + "<tr>";
                        strTableHtml = strTableHtml + "<td>" + item.name + "</td>";
                        strTableHtml = strTableHtml + "<td>" + item.num + "</td>";
                        strTableHtml = strTableHtml + "<td>" + item.password + "</td>";
                        strTableHtml = strTableHtml + "<td>" + item.age + "</td>";
                        strTableHtml = strTableHtml + "<td>" + item.sex + "</td>";
                        strTableHtml = strTableHtml + "<td>" + item.hobby + "</td>";
                        strTableHtml = strTableHtml + "<td>" + item.sheng + "</td>";
                        strTableHtml = strTableHtml + "<td>" + item.shi+ "</td>";
                        strTableHtml = strTableHtml + "</tr>";  
                    });
                   $("#title").html("");
                   $("#tbody-result").html("");
        
                    $("#title").append(strTableHtml1);
                    $("#tbody-result").append(strTableHtml);
                   
                },
                error: function (data) {
                    alert(data);
                }
			});
	 });
});

</script>
</html>