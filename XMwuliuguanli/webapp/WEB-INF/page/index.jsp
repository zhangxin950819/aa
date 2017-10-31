<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:if test="${ctx=='/'}">
	<c:set var="ctx" value="" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<title>欢迎使用物流管理系统后台</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css" />
<script type="text/javascript" src="${ctx}/js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/menu.js"></script>
</head>
<body>
	<%@include file="tempBegin.jsp"%>
	<div class="crumb-wrap">
		<div class="crumb-list">
			当前位置：<span class="crumb-name">首页</span>
		</div>
	</div>


	<%@include file="tempEnd.jsp"%>
</body>
</html>