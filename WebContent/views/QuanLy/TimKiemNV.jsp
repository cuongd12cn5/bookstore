<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tìm kiếm nhân viên</title>
</head>
<body>
	<center>
		<form:form method="POST" action="../admin/timkiemNV.html">
			<table>
				<tr>
					<td>Tên nhân viên</td>
					<td><form:input path="tenNV" /></td>
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
				<td>Tên nhân viên</td>
				<td>Địa chỉ</td>
				<td>SĐT liên hệ</td>
				<td>Vị trí</td>
			</tr>
			<c:forEach var="nv" items="${listnv}" varStatus="i">
				<tr>
					<td>${i.index+1 }</td>
					<td>${nv.tenNV}</td>
					<td>${nv.diaChi}</td>
					<td>${nv.lienHe}</td>
					<td>${nv.viTri}</td>
					<td><a href="../admin/xoaNV.html?id=${nv.maNV }">Xóa</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<a href="../admin/QLNV.html">Quay lại</a>
	</center>
</body>
</html>