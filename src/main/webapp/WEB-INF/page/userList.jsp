<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap.css" />
<script type="text/javascript" src="${ctx}/scripts/jquery-3.1.1.min.js" ></script>
<script type="text/javascript" src="${ctx}/js/user.js"></script>
<style>
.img1:hover {
	width: 100px;
	height: 100px;
}
</style>
<title>用户列表</title>
</head>
<body>
<font color="#777777"><strong style="font-size: 20px">管理员信息：</strong>
	</font>
	<br>
	<table class="table table-bordered table-hover definewidth m10">
		<thead class="thead1">
			<tr>
				<th>序号</th>
				<th>用户名</th>
				<th>邮箱</th>
				<th>电话号码</th>
				<th>性别</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		<c:forEach items="${list }" var="item" varStatus="status">
			<tr>
				<td>${ status.index  + 1}</td>
				<td>${item.name }</td>
				<td>${item.email }</td>
				<td>${item.phone }</td>
				<td>
					<c:choose>
						<c:when test="${item.sex==0}">男</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${item.sex==1}">女</c:when>
					</c:choose>
				</td>
				<td>
					<a href="${ctx}/user/deleteUser?id=${item.id}" class="a2">删除</a>
					<a href="${ctx}/user/toUpdate?id=${item.id}" class="a2">修改</a>
				</td>
			</tr>

		</c:forEach>
	</table>
</body>
<script type="text/javascript">
	var ctx="${ctx}";
</script>
</html>