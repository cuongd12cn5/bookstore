<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đơn đặt hàng</title>
</head>
<body>
	<center>
		<table align="center" border="solid 1px" width="80%"
			bordercolor="black" style="border-collapse: collapse;">
			<tr>
				<td>STT</td>
				<td>Mã đơn</td>
				<td>Mã khách hàng</td>
				<td>Tên khách hàng</td>
				<td>Địa chỉ</td>
				<td>Mã sách</td>
				<td>Tên sách</td>
				<td>Số lượng</td>
				<td>Ngày đặt</td>
			</tr>
			<c:forEach var="datsach" items="${listDatSach }" varStatus="i">
				<tr>
					<td>${i.index+1 }</td>
					<td>${datsach.maDatSach}</td>
					<td>${datsach.kh.maKH}</td>
					<td>${datsach.kh.tenKH}</td>
					<td>${datsach.kh.diaChi}</td>
					<td>${datsach.sach.maSach}</td>
					<td>${datsach.sach.tenSach}</td>
					<td>${datsach.soLuong}</td>
					<td>${datsach.ngayDat}</td>
					<td><a href="../banhang/checkDonHang.html?maDon=${datsach.maDatSach }">Check đơn</a></td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="../frame/userProfile.html">Quay lại</a>
	</center>
</body>
</html>