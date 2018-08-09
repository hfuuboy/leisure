<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/css/admin.css">
<script src="${ctx}/scripts/jquery-3.1.1.min.js"></script>
<script src="${ctx}/scripts/jquery-3.1.1.min.js"></script>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="${ctx}/login/userLogin" method="post" onsubmit="">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>后台管理中心</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="name""
										placeholder="登录账号" data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big"
										name="password" placeholder="登录密码"
										data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							
							<!-- 验证码开始 -->
							<div class="form-group">
									   验证码：<input type="text" name="image" style="width: 30%;height:34px;"/>
									 <img src="${ctx }/validate/verifyCode" id="imgId">
									 <input type="button" value="看不清? 换一张" id="btn" style="width: 30%;font-size:12px;height: 38px;" class="bg-main">
									 <font color="red">${imageMess }</font>
							</div>
							<!-- 验证码结束 -->
							
							<p><span style="color: red;font-size: 15px;">${errorMessage}<span></p>
						</div>
						
						<s:property value="#request.error"/>
						<div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

	$(function(){
		//alert("${ctx}");
		$("#btn").click(function(){
			$("#imgId").attr("src","${ctx }/validate/verifyCode?time" + new Date().getTime()); 
		});
	});
	
</script>
</html>