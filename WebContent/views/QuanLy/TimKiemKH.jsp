<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tìm kiếm khách hàng</title>
</head>
<body>
	<center>
		<form:form method="POST" action="../admin/timkiemKH.html">
			<table>
				<tr>
					<td>Tên khách hàng</td>
					<td><form:input path="tenKH" /></td>
					<td><input type="submit" value="Tìm kiếm" /></td>
				</tr>
			</table>
			<br>
			<h3>${thongbaoxoa }</h3>
		</form:form>
		<table align="center" border="solid 1px" width="80%"
			bordercolor="black" style="border-collapse: collapse;">
			<tr>
				<td>STT</td>
				<td>Mã khách hàng</td>
				<td>Tên khách hàng</td>
				<td>Địa chỉ</td>
				<td>SĐT liên hệ</td>
			</tr>
			<c:forEach var="kh" items="${listkh}" varStatus="i">
				<tr>
					<td>${i.index+1 }</td>
					<td>${kh.maKH}</td>
					<td>${kh.tenKH}</td>
					<td>${kh.diaChi}</td>
					<td>${kh.lienHe}</td>
					<td><a href="../admin/xoaKH.html?id=${kh.maKH }">Xóa</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<a href="../frame/userProfile.html">Quay lại trang quản lý</a>
	</center>
</body>
</html>