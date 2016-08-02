<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
<link href="../css/homecss.css" rel="stylesheet" type="text/css" />
</head>
<%@include file="header.jsp"%>
<body>
	<div id="conten_right">
		<center>
			<form:form method="POST" action="../frame/loginCheck.html">
				<br><br>
				<table>
					<tr>
						<td>Tên đăng nhập</td>
					</tr>
					<tr>
						<td><form:input path="tenDangNhap" /></td>
					</tr>
					<tr>
						<td>Mật khẩu</td>
					</tr>
					<tr>
						<td><form:password path="matKhau" /></td>
					</tr>
				</table>
				<br>
				<input type="submit" value="Đăng nhập" />
			</form:form>
			<h3>${thongbao}</h3>
			<br><br>
		</center>
	</div>
</body>
<%@include file="footer.jsp"%>
</html>