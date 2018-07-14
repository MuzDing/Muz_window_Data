<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.io.BufferedReader" %>
<%@ page import = "java.io.InputStreamReader" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
				 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
}
</style>

<script type="text/javascript">
	function sendcode(){
		
		var usid = document.getElementById("username").value;
		if(usid!="" && usid!=null){
			location.href = "${pageContext.request.contextPath}/sendEmail?usid="
				+ usid;
		}else{
			alert("请输入用户名!");
		}
		
	}
	$(function(){  
        $("#getCode").removeAttr("disabled"); 
        //发送验证码  
        $("#getCode").click(function(){   
            $.ajax({  
                url:"${pageContext.request.contextPath}/sendEmail",  
                data:{  
                    "us_id":$("#username").val()
                },  
                type:"post",  
                async:false,  
                dataType:"text",  
                success : function(data) {  
                    if(1 == data){  
                        alert("验证码发送成功，收到后请输入验证码");  
                        time(this);  
                    } else {  
                        alert("验证码发送失败");  
                    }  
                },  
                error : function() {  
                    alert("error");  
                }  
            });  
        });  
        //验证  
        $("#validate").click(function(){      
            $.ajax({  
                url:"code",  
                data:{  
                    "code":$("#code").val()  
                },  
                type:"post",  
                async:false,  
                dataType:"text",  
                success : function(data) {  
                    if(data=='true'){  
                        alert("恭喜您，验证成功");  
                    } else {  
                        alert("验证失败");  
                    }  
                },  
                error : function() {  
                    alert("error");  
                }  
            });  
        });  
    })  
      
    //验证码倒计时  
    var wait = 60;  
    function time(obj) {  
        if(wait==0) {  
            $("#getCode").removeAttr("disabled");  
            $("#getCode").val("获取验证码");  
            wait = 60;  
        }else {  
            $("#getCode").attr("disabled","true");  
            $("#getCode").val(wait+"秒后重试");  
            wait--;  
            setTimeout(function() {     //倒计时方法  
                time(obj);  
            },1000);    //间隔为1s  
        }  
    }  
</script>  
	
</script>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="container"
		style="width: 100%; height: 460px; background: #FF2C4C url('images/loginbg.jpg') no-repeat;">
		<div class="row">
			<div class="col-md-7">
				<!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
			</div>

			<div class="col-md-5">
				<div
					style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
					<font>会员登录</font>USER LOGIN
					<div>&nbsp;</div>
					<form class="form-horizontal" action="${pageContext.request.contextPath}/userlogin">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="username" name = "userid"
									placeholder="请输入用户名"> 
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="inputPassword3" name="userpassword"
									placeholder="请输入密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="inputPassword3" name="usercode"
									placeholder="请输入验证码">
									
							</div>
							<div class="col-sm-3">
								<!-- <img src="./image/captcha.jhtml" /> -->
								<!-- <a href="#" onclick="sendcode1() placeholder="4位验证码">发送验证码 </a>   -->
								<input id="getCode" type="button" value="发送验证码"> 
								
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" name="autoLogin" value="autoLogin"> 自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
										type="checkbox"> 记住用户名
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="登录" name="submit"
									style="background: url('./images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>