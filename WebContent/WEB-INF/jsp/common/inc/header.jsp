<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

	<div id="header">
		<div id="tool-bar">
			&nbsp;&nbsp; 欢迎光临汇智动力图书网，[
			<c:if test="${ empty user}">
				<a href="${path }/user/toLogin">请登录</a>
			</c:if>
			<c:if test="${not empty user}">
				<a href="javascript:void(0);"><span style="font-weight: bold;color: orange;">${user.UName }</span></a>
			</c:if>

			]&nbsp;[ <a href="${path }/user/toRegist">免费注册</a>
			]&nbsp;&nbsp;&nbsp;<a href="${path }/index">首页</a>&nbsp;|&nbsp;<a
				href="${path }/cart/toCart">购物车</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|&nbsp;<a
				href="#">帮助</a>
		</div>
		<h1>
			汇智动力图书网-<span
				style="font-size: 48px; font-family: Arial; font-weight: lighter;">Book</span>
		</h1>
	</div>

</body>
</html>