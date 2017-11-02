<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:if test="${ctx=='/'}">
	<c:set var="ctx" value="" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<title>物流管理系统登录</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<script>
	window.onload = function(){
		var img = document.getElementById("img");
		var imgText = document.getElementById("img-text");
		img.onclick = function(){
			var date = new Date();
			img.src = "${ctx}/verifyImgAction?"+date;
		}
		img.onmouseover = function(){
			imgText.style.display = "block";
		}
		img.onmouseout = function(){
			imgText.style.display = "none";	
		}
		
		var button = document.getElementById("button");
		var form = document.getElementById("form");
		button.onclick = function(){
			form.submit();
		}
		document.body.onkeydown=function(event){
			var e = event || window.event || arguments.callee.caller.arguments[0];
			if(e && e.keyCode==13){
				form.submit();
			}
		}; 
	}

</script>
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎使用物流管理系统</h3>
						<form action="${ctx}/loginAction_login.action"  id="form" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账号" value="${admin.username}">
								<h3 style="color:red;position:absolute;top:-10px;left:350px;width:100px">${error.username}</h3>
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"  type="password" placeholder="请输入密码" value="${admin.password}">
								<h3 style="color:red;position:absolute;top:-10px;left:350px;width:100px">${error.password}</h3>
							</div>
							<div class="input_outer">
								<span class="uu_user"></span>
								<input name="verifyCode" class="text" style="width:140px;color: #FFFFFF !important" type="text" placeholder="请输入验证码">
								<img id="img" style="position: absolute;margin: 10px 13px;width:100px;height:25px"  src="${ctx}/verifyImgAction"><span id="img-text" style="display: none;position: absolute;left:190px;top:-20px;">看不清?点击刷新！</span>
								<h3 style="color:red;position:absolute;top:-10px;left:350px;width:100px">${error.verifycode}</h3>
							</div>
							<div class="mb2"><a id="button" class="act-but submit" href="javaScript:;" style="color: #FFFFFF">登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
	</body>
</html>