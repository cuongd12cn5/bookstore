<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa sách</title>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
</head>
<body>
	<center>
		<fieldset>
			<legend>
				<h2>Thông tin sách</h2>
			</legend>
			</br> </br> </br>
			<form:form method="POST"
				action="../banhang/editSach.html?maSach=${sach.maSach }">

				<table>
					<tr>
						<td>Tên sách</td>
						<td><form:input value="${sach.tenSach }" path="tenSach" /></td>
					</tr>
					<tr>
						<td>Tác giả</td>
						<td><form:input value="${sach.tacGia }" path="tacGia" /></td>
					</tr>
					<tr>
						<td>Nhà xuất bản</td>
						<td><form:input value="${sach.nhaXuatBan }" path="nhaXuatBan" /></td>
					</tr>
					<tr>
						<td>Năm xuất bản</td>
						<td><form:input value="${sach.namXuatBan }" path="namXuatBan" /></td>
					</tr>
					<tr>
						<td>Ảnh</td>
						<td><form:hidden value="${sach.image }" path="image" /> <img
							src="../img/${sach.image }" width="130px" height="120px" /> <br>
						</td>
					</tr>
					<tr>
						<td>Giá</td>
						<td><form:input value="${sach.gia }" path="gia" /></td>
					</tr>
					<tr>
						<td>Mô tả</td>
						<td><textarea rows="5" cols="40" name="moTa" id="moTa">
							${sach.moTa}
							</textarea></td>
					</tr>
				</table>
				<br />
				<input type="submit" value="Sửa" />
			</form:form>
			</br> </br> <a href="../banhang/QLSach.html">Quay lại</a>
			<h3>${thongbao }</h3>
		</fieldset>
		</br>
	</center>
</body>
<script type="text/javascript">
	CKEDITOR.replace('moTa');
</script>
</html>