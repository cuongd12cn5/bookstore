<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm nhân viên</title>
</head>
<body>
	<center>
		<fieldset>
			<legend>
				<h2>Thông tin tài khoản</h2>
			</legend>
			</br> </br> </br>
			<form:form method="POST" action="../admin/themNV.html">

				<table>
					<tr>
						<td>Tên đăng nhập</td>
						<td><form:input path="tenDangNhap" /></td>
					</tr>
					<tr>
						<td>Mật khẩu</td>
						<td><form:password path="matKhau" /></td>
					</tr>
					<tr>
						<td>Họ và tên</td>
						<td><form:input path="tenNV" /></td>
					</tr>
					<tr>
						<td>SĐT liên hệ</td>
						<td><form:input path="lienHe" /></td>
					</tr>
					<tr>
						<td>Địa chỉ</td>
						<td><form:input path="diaChi" /></td>
					</tr>
					<tr>
						<td>Vị trí</td>
						<td><form:select path="quyen">
								<form:option value="1">Quản lý</form:option>
								<form:option value="0">Bán hàng</form:option>
							</form:select></td>
					</tr>
				</table>
				<br />
				<input type="submit" value="Thêm" />
			</form:form>
			</br> </br>
			<h2>${thongbao}</h2>
			 <a href="../admin/QLNV.html">Quay lại</a>
		</fieldset>
		</br>
	</center>
</body>
</html>