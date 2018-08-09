<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户新增</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap.css" />
<script type="text/javascript" src="${ctx}/scripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${ctx}/js/user.js"></script>
<style type="text/css">
body {
	font-size: 20px;
	padding-bottom: 40px;
	background-color: white;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

.btn {
	position: absolute;
	top: 50%;
	left: 40%;
	color: blue;
	font-size: 20px;
}
</style>
</head>
<body>
	<form id="updateForm" method="post">
		<input type="hidden" id="id"  name="id" value="${user.id}" />
		<strong style="font-size: 20px">添加用户：</strong>
		<table class="table table-bordered table-hover m10"
			style="margin-left: 10px; margin-top: 3px;">
			<tr>
				<td>用户名：</td>
				<td><input class="form-control" type="text" name="name" id="name" value="${user.name}"/></td>

			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input class="form-control" type="text" name="email" id="email" value="${user.email}"/></td>
			</tr>
			<tr>
				<td>电话号码：</td>
				<td><input class="form-control" type="text" name="phone" id="phone" value="${user.phone}"/></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input class="form-control" type="radio" name="sex" value="0" <c:if test="${user.sex== 0}">checked="checked"</c:if>/>男
					<input class="form-control" type="radio" name="sex" value="1" <c:if test="${user.sex== 1}">checked="checked"</c:if> />女
				</td>
			</tr>
		</table>
		<input type="button" value="确定" class="btn" id="updateFormBtn" />
	</form>
</body>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
</html>