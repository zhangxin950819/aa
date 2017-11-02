<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:if test="${ctx=='/'}">
	<c:set var="ctx" value="" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<title>${!empty editAmin ? "编辑" : "添加"}管理员</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css" />
<script type="text/javascript" src="${ctx}/js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/menu.js"></script>
</head>
<body>
	<%@include file="../tempBegin.jsp"%>
	<c:if test='${!empty editAdminError}'>
		<script>alert("${editAdminError}")</script>
	</c:if>
	<div class="crumb-wrap">
		<div class="crumb-list">
			当前位置：<a href="${ctx}/administratorAction_index.action">首页</a>
			<c:if test="${!empty editAmin}">
				<span class="crumb-step">&gt;</span><a href="${ctx}/administratorAction_adminList.action">管理员列表</a>
			</c:if>
			<span class="crumb-step">&gt;</span><span class="crumb-name">${!empty editAmin ? "编辑" : "添加"}管理员</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="${ctx}/administratorAction_editAdmin.action"
				method="post">
				<input type="hidden"  value="${admin.username}" name="username"/>
				<input type="hidden"  value="${admin.password}" name="password"/>
				<table class="insert-tab" width="100%">
					<tbody>
						<tr>
							<th width="120">管理员类别：</th>
							<td><select name="typeId">
									<c:forEach items="${administratorTypeList}" var="type">
										<option
											${admin.administratorType.typeId==type.typeId ? "selected" : ""}
											value="${type.typeId}">${type.typeName}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th>管理员所属区域：</th>
							<td><select name="districtId">
									<c:forEach items="${districtList}" var="district">
										<option
											${admin.district.districtId==district.districtId ? "selected" : ""}
											value="${district.districtId}">${district.districtName}</option>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<th>管理员身份证号：</th>
							<td><input class="common-text" required name="id" ${!empty editAmin ? "readOnly" : ""}
								value="${admin.id}" size="50" type="text"></td>
						</tr>
						<tr>
							<th>管理员姓名：</th>
							<td><input class="common-text" required name="name" ${!empty editAmin ? "readOnly" : ""}
								value="${admin.name}" size="50" type="text"></td>
						</tr>
						<tr>
							<th>管理员联系电话：</th>
							<td><input class="common-text" required name="phonenumber"
								value="${admin.phonenumber}" size="50" type="text"></td>
						</tr>
						<tr>
							<th>管理员家庭住址：</th>
							<td><input class="common-text" required name="address"
								size="50" value="${admin.address}" type="text"></td>
						</tr>
						<tr>
							<th></th>
							<td><input class="btn btn-primary btn6 mr10" value="提交"
								type="submit"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>


	<%@include file="../tempEnd.jsp"%>
</body>
</html>