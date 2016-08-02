<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="dangnhap">
			<ul>
				<li><a>Hotline: <span>1900 8198</span></a></li>
				<c:choose>
					<c:when test="${sessionScope.user == null}">
						<li><a href="../frame/register.html">Đăng ký</a></li>
						<li><a href="../frame/login.html">Đăng nhập</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="../frame/userProfile.html">Welcome ${user}</a></li>
						<li><a href="../frame/logout.html">Logout</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div id="banner"></div>
		<div id="menu">
			<div id="menu1">
				<ul>
					<li><a href="../frame/homepage.html"><span>Trang
								chủ</span></a></li>
					<c:forEach var="danhmucsach" items="${listDanhMuc }">
						<li><a href="../frame/typeSach.html?type=${danhmucsach.maDanhMuc}"><span>${danhmucsach.tenDanhMuc}</span></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>