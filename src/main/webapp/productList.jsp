<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>상품목록 페이지</title>
		<link rel="stylesheet" href = "style.css">
	</head>
	<body>
		<div id="wrap">
		<h1>상품 리스트</h1>
			<table>
				<tr>
					<td colspan="6">성품 목록</td>
				</tr>
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>가격</td>
					<td>수정</td>
					<td>삭제</td>
				</tr>
				<c:forEach items = "${productlist}" var="product">
					<tr>
						<td>${product.getCode() }</td>
						<td>${product.getName() }</td>
						<td>${product.getPrice() }</td>
						<td>수정</td>
						<td>삭제</td>
					</tr>
				</c:forEach>	
			</table>
		</div>
	</body>
</html>