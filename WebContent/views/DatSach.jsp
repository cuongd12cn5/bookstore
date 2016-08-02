<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Store</title>
<link href="../css/homecss.css" rel="stylesheet" type="text/css" />
<link href="../css/style_slide.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@include file="header.jsp"%>
	<div id="home">
		<div id="image">
			<img src="../img/${sach.image }">
		</div>
		<div id="thongtin">
			<center>
				<table style="border-collapse: collapse;">
					<tr>
						<th></th>
						<td></td>
						<th>${sach.tenSach }</th>
					</tr>
					<tr>
						<th></th>
						<td></td>
						<td >${sach.moTa }</td>
					</tr>
					<tr>
						<th></th>
						<td></td>
						<th>Giá ${sach.gia }đ</th>
					</tr>
				</table>
				<br> <br>
				<form:form action="../frame/DatSach.html?maSach=${sach.maSach }"
					method="POST">
					Số lượng <form:input path="soLuong" value="1" size="5" />
					<br />
					<br />
					<input type="submit" name="submit" value="Đặt sách" />
				</form:form>
				<br><br>
				<h3>${thongbaoDatSach }</h3>
				<h3>${thongbao }</h3>
			</center>
		</div>
	</div>
</body>
<%@include file="footer.jsp"%>
</html>