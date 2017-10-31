<%@ page language="java" contentType="text/html; charset=utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:if test="${ctx=='/'}">
	<c:set var="ctx" value="" />
</c:if>
<div class="topbar-wrap white">
	<div class="topbar-inner clearfix">
		<div class="topbar-logo-wrap clearfix">
			<ul class="navbar-list clearfix">
				<li>后台管理</li>
			</ul>
		</div>
		<div class="top-info-wrap">
			<ul class="top-info-list clearfix">
				<li><a href="#">修改密码</a></li>
				<li><a href="#">退出</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="container clearfix">
	<div class="sidebar-wrap">
		<div class="sidebar-title">
			<h1>菜单</h1>
		</div>
		<div class="sidebar-content">
			<ul class="sidebar-list">
			   <c:forEach items="${sessionScope.MNUELIST_IN_SESSION.get(0)}" var="parentmenu">
				<li parentMenu ><a href="javascript:;"><i class="icon-font">${parentmenu.img}</i>${parentmenu.menuName}</a>
					<ul class="sub-menu" style="display: none">
						<c:forEach items="${sessionScope.MNUELIST_IN_SESSION.get(1)}" var="menu">
							 <c:if test="${parentmenu.menuId eq menu.parentMenuId}"> 
								<li><a href="${ctx}/${menu.url}"><i class="icon-font">${menu.img}</i>${menu.menuName}</a></li>
							 </c:if> 
						</c:forEach>
					</ul>
				</li>
			   </c:forEach>
		   </ul>
		</div>
	</div>
	<div class="main-wrap">
    <div class="crumb-wrap">
         <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎管理员${sessionScope.ADMIN_IN_SESSION.name}使用物流管理系统后台</span></div>
    </div>
