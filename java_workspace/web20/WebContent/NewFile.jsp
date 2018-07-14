<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>验证码</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript">  
        $(function(){  
            $("#getCode").removeAttr("disabled");  
            //发送验证码  
            $("#getCode").click(function(){   
                $.ajax({  
                    url:"message",  
                    data:{  
                        "phone":$("#phone").val()  
                    },  
                    type:"post",  
                    async:false,  
                    dataType:"text",  
                    success : function(data) {  
                        if(data=='true'){  
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
</head>

<body>
<input type="text" id="phone" placeholder="请输入手机号码"><input id="getCode" type="button" value="获取验证码"><br>  
    <input type="text" id="code" placeholder="6位验证码"><input id="validate" type="button" value="验证">  

</body>

</html>