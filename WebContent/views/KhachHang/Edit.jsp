<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa đổi thông tin</title>
</head>
<body>
	<br />
	<center>
		<form:form method="POST" action="../customer/Edit.html">
			<table>
				<tr>
					<td>Mật khẩu</td>
					<td><form:password path="matKhau"
							value="${kh.matKhau }" /></td>
				</tr>
				<tr>
					<td>Họ và tên</td>
					<td><form:input path="tenKH" value="${kh.tenKH }" /></td>
				</tr>

				<tr>
					<td>Địa chỉ</td>
					<td><form:input path="diaChi" value="${kh.diaChi }" /></td>
				</tr>
				<tr>
					<td>Số điện thoại liên hệ</td>
					<td><form:input path="lienHe"
							value="${kh.lienHe }" /></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Cập nhật" />
			<!-- <input type="submit" value="Quay lại" onclick="form.action='homepage.html',method='post'"/>  -->
			<h3>${thongbao}</h3>
			<br><br>
			<a href="../frame/homepage.html">Quay lại trang chủ</a>
		</form:form>
		<br /> <br />
	</center>
</body>
</html>