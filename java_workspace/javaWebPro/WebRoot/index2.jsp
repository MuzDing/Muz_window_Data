<%@page import="com.entity.CountNumber"%>
<%@page import="com.entity.SysUser"%>
<%@page import="com.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	
  	<c:if test="${userList == null}">
  		<c:redirect url="user.do?action=queryUserList&pageIndex=1"></c:redirect>
  	</c:if>
    
    	<%
	    	request.setAttribute("userCount", CountNumber.userCount);
 		%>
 		
 		<c:if test="${userLogin != null}">
 			欢迎您：【${userLogin.usrNickname}】,
 		</c:if>
    	当前在线人数为：${userCount}
    	
    	<a href="user.do?action=unLogin">注销</a>
    	
    	<form id="form1" action="user.do" style="text-align: center;">
    		<input type="hidden" name="action" value="queryUserList" />
    		<input type="hidden" name="pageIndex" id="pageIndex" value="1" />
    		用户名：<input type="text" name="userName" value="${userName}" />
    		角色：<input type="text" name="userRole" value="${userRole}" />
    		<input type="submit" value="查询">
    	</form>
    	
    	<table border="1px" width="97%" style="line-height: 30px;margin: 20px;text-align: center;">
    		<tr style="background-color: rosybrown;">
    			<td>编号</td>
    			<td>头像</td>
    			<td>用户名</td>
    			<td>昵称</td>
    			<td>角色</td>
    			<td>错误次数</td>
    			<td>是否启用</td>
    		</tr>
    		<c:forEach items="${userList}" var="u" varStatus="rn">
    		<tr 
    			<c:if test="${rn.index % 2 != 0}">
    				style="background-color: cornsilk;"
    			</c:if>
    		>
    			<td>${u.usrId}</td>
    			<td><img src="images/user/${u.usrImage}" style="width: 40px;" /></td>
    			<td>${u.usrName}</td>
    			<td>${u.usrNickname}</td>
    			<td>${u.usrRole}</td>
    			<td>${u.usrNum}</td>
    			<td>
					<c:if test="${u.usrStatus == 0}">
						否
					</c:if>
					<c:if test="${u.usrStatus == 1}">
						是
					</c:if>
				</td>
    		</tr>
    		</c:forEach>
    	</table>
    	
    	<div style="text-align: center;">
	    	<button onclick="page_to(1)">首页</button>
	    	<c:if test="${pageIndex <=1}">
	    		上一页
	    	</c:if>
	    	<c:if test="${pageIndex >1}">
	    		<button onclick="page_to(${pageIndex - 1})">上一页</button>
	    	</c:if>
	    	
	    	(${pageIndex} / ${pageTotal}) 
	    	
	    	<c:if test="${pageIndex >= pageTotal}">
	    		下一页
	    	</c:if>
	    	<c:if test="${pageIndex < pageTotal}">
	    		<button onclick="page_to(${pageIndex + 1})">下一页</button>
	    	</c:if>
	    	
	    	<button onclick="page_to(${pageTotal})">尾页</button>
	    	
	    	<span>
	    	 <label>跳转至</label>
		     <input type="text" name="inputPage" id="inputPage" />页
		     <button type="button" onClick="jump_to()">GO</button>
		    </span>
	    </div>
	    
	    <script type="text/javascript">
	    	var form1 = document.getElementById("form1");
	    	
	    	//显示某页数据，pageTo表示第几页
		    function page_to(pageTo){
		    	document.getElementById("pageIndex").value = pageTo;
    			form1.submit();
		    }
		   
	    	//跳转至哪页
	    	function jump_to(){
	    		var pageno = document.getElementById("inputPage").value;
	    		//验证数字
	    		var rep = /^[1-9]\d*$/;
	    		if(!rep.test(pageno)){
	    			alert("请输入正确的数字");
	    		}else if(pageno > ${pageTotal}){	//判断跳转的页数是否大于尾页
	    			alert("跳转的页，不能大于尾页");
	    		}else{
	    			page_to(pageno);
	    			//window.location.href="user.do?action=queryUserList&pageIndex="+pageno;
	    		}
	    	}
	    </script>
  </body>
</html>
