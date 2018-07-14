<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员管理-有点</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/manhuaDate.1.0.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/manhuaDate.1.0.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
</head>

<body>
	<c:if test="${userList == null}">
  		<c:redirect url="user.do?action=queryUserList&pageIndex=1"></c:redirect>
  	</c:if>

	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">系统管理</a>&nbsp;-</span>&nbsp;用户管理
			</div>
		</div>

		<div class="page">
			<!-- vip页面样式 -->
			<div class="vip">
				<div class="conform">
					<form id="form1" action="user.do">
						<input type="hidden" name="action" value="queryUserList" />
    					<input type="hidden" name="pageIndex" id="pageIndex" value="1" />
						<div class="cfD" style="width: 300px;float: left;">
							用户名：<input class="addUser" type="text" placeholder="输入用户名" />
						</div>
						<div class="cfD" style="width: 450px;float: left;margin-bottom: 20px;">
							角色：<input class="addUser" type="text" placeholder="输入角色" />
							<button class="button" onclick="page_to(1)">搜索</button>
						</div>
						
					</form>
				</div>
				<!-- vip 表格 显示 -->
				<div class="conShow" style="clear: both;">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">序号</td>
							<td width="250px" class="tdColor">头像</td>
							<td width="188px" class="tdColor">用户名</td>
							<td width="235px" class="tdColor">昵称</td>
							<td width="220px" class="tdColor">角色</td>
							<td width="290px" class="tdColor">错误次数</td>
							<td width="282px" class="tdColor">是否启用</td>
							<td width="130px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${userList}" var="u" varStatus="rn">
				    		<tr>
				    			<td>${u.usrId}</td>
				    			<td>
				    			<div class="onsImg onsImgv">
									<img src="images/user/${u.usrImage}" style="width: 70px;" />
								</div>
				    			</td>
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
								<td><a href="connoisseuradd.html"><img class="operation"
									src="img/update.png"></a> <img class="operation delban"
								src="img/delete.png"></td>
				    		</tr>
				    		</c:forEach>
					</table>
					<div class="paging">此处是分页</div>
				</div>
				<!-- vip 表格 显示 end-->
			</div>
			<!-- vip页面样式end -->
		</div>

	</div>


	<!-- 删除弹出框 -->
	<div class="banDel">
		<div class="delete">
			<div class="close">
				<a><img src="img/shanchu.png" /></a>
			</div>
			<p class="delP1">你确定要删除此条记录吗？</p>
			<p class="delP2">
				<a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
</body>

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
</html>