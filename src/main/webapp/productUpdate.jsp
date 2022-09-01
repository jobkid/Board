<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>상품 관리</title>
		<link rel = "stylesheet" href = "style.css">
	</head>
	<body>
		<div id = "wrap">
			<h1>상품 수정</h1>
			<form method = "post" enctype = "multipart/form-data" name = "frm">
				<input type = "text" name = "code" value = "${product.getCode() }">
				<input type = "text" name = "nomakeImg" value = "${product.getPictureurl() }">		
				<input type = "submit" value = "다시 작성">
				<input type = "button" value = "목록보기" onclick = "location.href='ProductList'">
			</form>
		</div>
	</body>
</html>