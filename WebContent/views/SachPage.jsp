<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HCfashion</title>
</head>
<link href="../css/homecss.css" rel="stylesheet" type="text/css" />

<body>
	<div class="select">
		<form:form action="../frame/searhSach.html" method="POST" name="form1">
			<form:input path="tenSach" class="text-select" value=""
				placeholder="Nhập tên sản phẩm..." />
			<input type="submit" name="submit" class="sub-select"
				value="Tìm kiếm" />
		</form:form>
	</div>
	<%@include file="header.jsp"%>
	<div id="sanpham">
		<c:forEach var="sach" items="${listSach }">
			<div id="sp">
				<a href="../frame/ViewSach.html?id=${sach.maSach }"><img
					src="../img/${sach.image }" width="270px" height="350px"></a><br> <br>
				<p><h4>${sach.tenSach }</h4></p>
				<p id="gia"><h4>${sach.gia }đ</h4></p>
			</div>
		</c:forEach>
	</div>
</body>
<%@include file="footer.jsp"%>
</html>