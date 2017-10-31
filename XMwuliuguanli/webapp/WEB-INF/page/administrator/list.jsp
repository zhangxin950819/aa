<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:if test="${ctx=='/'}">
	<c:set var="ctx" value="" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<title>管理员列表</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css" />
<script type="text/javascript" src="${ctx}/js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/menu.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/css/page.css" />
</head>
<body>
	<%@include file="../tempBegin.jsp"%>
	<c:if test='${!empty adminListMsg}'>
		<script>alert("${adminListMsg}")</script>
	</c:if>
	<div class="crumb-wrap">
		<div class="crumb-list">
			当前位置：<a href="${ctx}/administratorAction_index.action">首页</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">管理员列表</span>
		</div>
	</div>
	<form id="form" action="${ctx}/administratorAction_adminList.action" method="post">
	<div class="search-wrap">
		<div class="search-content">
				<table class="search-tab">
					<tr>
						<th width="120">选择管理员类别:</th>
						<td><select id="admintype" name="adminType" >
								<option value="0">全部</option>
								<c:forEach items="${adminTypeList}" var="type">
									<option	${page.adminType==type.typeId ? "selected" : ""}
										value="${type.typeId}">${type.typeName}</option>
								</c:forEach>
						</select></td>
						<th width="120">管理员姓名:</th>
						<td><input class="common-text" placeholder="管理员姓名"
							name="adminName" value="${page.adminName}" type="text"></td>
						<td><input class="btn btn-primary btn2" name="sub" value="查询"
							type="submit"></td>
					</tr>
				</table>
		</div>
	</div>
	<div class="result-wrap">
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th>身份证号</th>
						<th>姓名</th>
						<th>电话号</th>
						<th>家庭住址</th>
						<th>地区</th>
						<th>管理员类型</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${adminList}" var="admin">
					<tr>
						<td>${admin.id}</td>
						<td>${admin.name}</td>
						<td>${admin.phonenumber}</td>
						<td>${admin.address}</td>
						<td>${admin.district}</td>
						<td>${admin.administratorType.typeName}</td>
						<td><a class="link-update" href="${ctx}/administratorAction_addAdmin.action?id=${admin.id}">修改</a> 
							<c:if test="${admin.administratorType.typeId!=0}">
								|<a  onclick="return confirm('确定删除该管理员?');" class="link-del"  href="${ctx}/administratorAction_deleteAdmin.action?id=${admin.id}">删除</a>
							</c:if>
						</td>
					</tr>
					</c:forEach>
					
				</table>
				
				
				
				<div class="list-page">
					<ul class="pagination"> 
						<li ${page.nowPage==1?"class='disabled'":""}>
							<a ${page.nowPage==1?"onclick='return false;'":""}  href="${ctx}/administratorAction_adminList.action?nowPage=${page.nowPage-1}&adminType=${page.adminType}&adminName=${page.adminName}">上一页</a></li>
						<c:forEach begin="1" end="${page.totalPageNumber}" varStatus="i">
							<li ${page.nowPage==i.index ? "class='active'" : ""}><a ${page.nowPage==i.index ? "onclick='return false;'" : ""} href="${ctx}/administratorAction_adminList.action?nowPage=${i.index}&adminType=${page.adminType}&adminName=${page.adminName}">${i.index}</a></li>
						</c:forEach>
						<li ${page.nowPage==page.totalPageNumber?"class='disabled'":""}>
							<a ${page.nowPage==page.totalPageNumber?"onclick='return false;'":""} href="${ctx}/administratorAction_adminList.action?nowPage=${page.nowPage+1}&adminType=${page.adminType}&adminName=${page.adminName}">下一页</a></li>
					</ul>
				</div>
				<center>${page.totalResultNumber} 条 ${page.nowPage}/${page.totalPageNumber} 页 &nbsp&nbsp&nbsp&nbsp每页
				<select id="pagenumber" name="pageNumber" >
						<c:forEach items="${page.pageNumberList}" var="pageNumber">
							<option	${page.pageNumber==pageNumber ? "selected" : ""}
										value="${pageNumber}">${pageNumber}</option>
						</c:forEach>
				</select>条</center>
			</div>
	</div>
	</form>
	<script>
	function mySubmit(){
		$("#form").submit();
	}
	$("#admintype").change(mySubmit);
	$("#pagenumber").change(mySubmit);
	</script>
	<%@include file="../tempEnd.jsp"%>
</body>
</html>