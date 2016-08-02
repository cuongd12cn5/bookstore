<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tra cứu sách</title>
</head>
<body>
	<center>
		<form:form method="POST" action="../banhang/searchSach.html">
			<table>
				<tr>
					<td>Tên sách</td>
					<td><form:input path="tenSach" /></td>
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
				<td>Mã sách</td>
				<td>Tên sách</td>
				<td>Tác giả</td>
				<td>Nhà xuất bản</td>
				<td>Năm xuất bản</td>
				<td>Link ảnh</td>
				<td>Giá</td>
				<td>Mô tả</td>
				<td>Tên danh mục</td>
			</tr>
			<c:forEach var="sach" items="${listSach}" varStatus="i">
				<tr>
					<td>${i.index+1 }</td>
					<td>${sach.maSach}</td>
					<td>${sach.tenSach}</td>
					<td>${sach.tacGia}</td>
					<td>${sach.nhaXuatBan}</td>
					<td>${sach.namXuatBan}</td>
					<td>${sach.image}</td>
					<td>${sach.gia}</td>
					<td>${sach.moTa}</td>
					<td>${sach.danhMuc.tenDanhMuc}</td>
					<td><a href="../banhang/viewEditSach.html?id=${sach.maSach }">Sửa</a></td>
					<td><a href="../banhang/deleteSach.html?id=${sach.maSach }">Xóa</a></td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
		<a href="../banhang/QLSach.html">Quay lại</a>
	</center>
</body>
</html>