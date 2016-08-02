<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm sách</title>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
</head>
<body>
	<center>
		<fieldset>
			<legend>
				<h2>Thông tin sách</h2>
			</legend>
			<br /> <br /> <br />
			<form:form method="POST" action="../banhang/addSach.html"
				enctype="multipart/form-data" onsubmit="return Validate();">

				<table>
					<tr>
						<td>Tên sách</td>
						<td><form:input path="tenSach" /></td>
					</tr>
					<tr>
						<td>Danh mục sách</td>
						<td><form:select path="danhMuc.maDanhMuc">.
								<c:forEach var="danhmucsach" items="${danhmuc }">
									<form:option value="${danhmucsach.maDanhMuc }">${danhmucsach.tenDanhMuc}</form:option>
								</c:forEach>
							</form:select></td>
					</tr>
					<tr>
						<td>Tác giả</td>
						<td><form:input path="tacGia" /></td>
					</tr>
					<tr>
						<td>Nhà xuất bản</td>
						<td><form:input path="nhaXuatBan" /></td>
					</tr>
					<tr>
						<td>Năm xuất bản</td>
						<td><form:input path="namXuatBan" /></td>
					</tr>
					<tr>
						<td>Ảnh</td>
						<td>
							<%-- <form:input type="file" path="image" id="image" name="image" /> --%>
							<input type="file" name="file" id="file"
							onchange="return Validate();" /> <img id="target" src="#"
							alt="preview image" class="showImagePreview"
							style="display: none;" />
						</td>
					</tr>
					<tr>
						<td>Giá</td>
						<td><form:input path="gia" /></td>
					</tr>
					<tr>
						<td>Mô tả</td>
						<td><form:textarea rows="10" cols="65" path="moTa" id="moTa"
								name="moTa" /></td>
					</tr>
				</table>
				<br />
				<input type="submit" value="Thêm" />
				<h3>${thongbao }</h3>
				<br>
				<a href="../banhang/QLSach.html">Quay lại</a>
			</form:form>
			<br /> <br />
		</fieldset>
		<br />
	</center>
</body>
<script type="text/javascript">
	CKEDITOR.replace('moTa');
	function Validate() {
		var image = document.getElementById("file").value;
		var tail_image = image.substring(image.indexOf(".") + 1, image.lenght);
		if (image == "") {
			alert("Bạn chưa chọn ảnh");
			return false;
		}
		if (tail_image != "jepg" && tail_image != "jpg" && tail_image != "png"
				&& tail_image != "gif") {
			alert("Tệp tin không đúng định dạng ảnh."
					+ "\nHệ thống chỉ chấp nhận những định dạng: jpeg, jpg, png, gif");
			return false;
		}
		return true;
	}
</script>
</html>