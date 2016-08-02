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
		<form:form method="POST" action="../banhang/Edit1.html">
			<table>
				<tr>
					<td>Mật khẩu</td>
					<td><form:password path="matKhau"
							value="${nv.matKhau }" /></td>
				</tr>
				<tr>
					<td>Họ và tên</td>
					<td><form:input path="tenNV" value="${nv.tenNV }" /></td>
				</tr>
				<tr>
					<td>Địa chỉ</td>
					<td><form:input path="diaChi" value="${nv.diaChi }" /></td>
				</tr>
				<tr>
					<td>Số điện thoại liên hệ</td>
					<td><form:input path="lienHe"
							value="${nv.lienHe }" /></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Cập nhật" />
			<br>
			<h3>${thongbao }</h3>
		</form:form>
		<br /> <br />
		<a href="../frame/userProfile.html">Quay lại trang quản lý</a>
	</center>
</body>
</html>