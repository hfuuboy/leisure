<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎${user.name }</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/css/admin.css">
<script src="${ctx}/scripts/jquery-3.1.1.min.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="${ctx }/images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" /> 后台管理中心
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-blue" href="${ctx }/login/logout"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>基本设置
		</h2>
		<ul style="display: block">
			<li><a href="${ctx }/user/toUserList"
				target="right"><span class="icon-caret-right"></span>操作员管理</a></li>
			<li><a href="${ctx }/user/addUser" target="right"><span
					class="icon-caret-right"></span>添加操作员</a></li>
		<%-- 	<li><a href="${ctx }/user/toUpdatePassword" target="right"><span
					class="icon-caret-right"></span>修改密码</a></li> --%>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>学生管理
		</h2>
		<ul>
			<li><a href="./student_showallStudent.do" target="right"><span
					class="icon-caret-right"></span>学生列表</a></li>
			<li><a href="addstudent.jsp" target="right"><span
					class="icon-caret-right"></span>添加学生</a></li>
			<li><a href="selectshowstudent.jsp" target="right"><span
					class="icon-caret-right"></span>查找学生</a></li>
		</ul>


	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="info.html" target="right" class="icon-home"> 首页</a>
		</li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
	</ul>
	<div class="admin"  name="right">
		<iframe src=""  name="right" width="100%" height="100%"></iframe>
	</div>

</body>
</html>