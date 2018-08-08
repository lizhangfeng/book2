<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>汇智动力图书网</title>
<link type="text/css" rel="stylesheet"
	href="<%=application.getContextPath()%>/css/styles.css" />
	<style type="text/css">
		.c:link{
			color: red;
			text-decoration: none;
			font-weight: bold;
			font-size: 14px;
		}
	</style>
	
</head>
<body>
	<div id="container">

		<jsp:include page="inc/header.jsp"></jsp:include>
		<jsp:include page="inc/search.jsp"></jsp:include>

		<div class="section-right">
			<h3 align="center" style="margin-bottom: 20px;">您选购的商品如下：</h3>
			<table align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td class="header" width="200">书名</td>
					<td class="header" width="60">单价</td>
					<td class="header" width="60">购物数量</td>
					<td class="header" width="60">小计</td>
					<td class="header" width="60">操作</td>
				</tr>

				<c:forEach items="${cart}" var="item">

					<tr>
						<td>${item.btitle }</td>
						<td>￥${item.BPrice }</td>
						<td><a class="c" href="${path }/cart/changeNum?bid=${item.bid }&count=${item.count-1}">&nbsp;-&nbsp;</a>${item.count }<a
							class="c" href="${path }/cart/changeNum?bid=${item.bid }&count=${item.count+1}">&nbsp;+&nbsp;</a>本</td>
						<td>￥${item.allPrice }</td>
						<td><input type="button" value="删除" onclick="deleteCart(${item.bid })"/></td>
					</tr>

				</c:forEach>

				<tr>
					<td colspan="5" class="header" style="text-align: right;">总计：￥0</td>
				</tr>
			</table>
			<div style="text-align: center; font-size: 14px; line-height: 40px;">
				<a href="${path }/order/user/addOrder" style="text-decoration: underline;">提交订单</a>
			</div>
		</div>
		<div class="cf"></div>
	</div>
	<div id="footer">
		<p>版权所有&copy;汇智动力教育</p>
	</div>
	</div>


	<script type="text/javascript">
	
		//删除购物车中的商品
		function deleteCart(bid) {
			location.href="${path}/cart/delete?bid="+bid;
		}
	</script>

</body>
</html>