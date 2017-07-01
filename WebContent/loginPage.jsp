<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Profil User</title>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<br><br>
	<table border="0" align="center">
		<tr>
			<td width="200">
				<!--   nama, alamat,... -->
				Nama<br><br>
				Password<br><br>
				Alamat<br><br>
				Tanggal Lahir<br>(yyyy-mm-dd)<br><br>
				Nomor Telepon<br><br>
				Email<br><br>
				<br><br><br>
			</td>
			<td width="100">
				<c:set var="user" value="${user}" scope="session"/>
				<c:set var="newlyLogIn" value="${newlyLogIn}" scope="session"/>
				<form action="memberListLogInServlet" method="post">
					<jsp:getProperty property="nama" name="user"/><!-- < % String nama = (String)request.getAttribute("$user.getNama()");%> < %=nama%> -->
					<br><br>
					<jsp:getProperty property="password" name="user"/> <!-- < % String password = (String)request.getAttribute("$user.getPassword()");%>< %=password%> -->
					<br><br>
					<jsp:getProperty property="alamat" name="user"/> <!-- < % String alamat = (String)request.getAttribute("$user.getAlamat()");%>< %=alamat%> -->
					<br><br>
					<jsp:getProperty property="tanggalLahir" name="user"/> <!-- < % String tanggalLahir = (String)request.getAttribute("$user.getTanggalLahir()");%>< %=tanggalLahir%> -->
					<br><br><br>
					<jsp:getProperty property="telepon" name="user"/> <!-- < % String telepon = (String)request.getAttribute("$user.getTelepon()");%>< %=telepon%> -->
					<br><br>
					<jsp:getProperty property="email" name="user"/> <!-- < % String email = (String)request.getAttribute("$user.getEmail()");%>< %=email%> -->
					<br><br>
					<!-- var nama, alamat,... -->
				</form>
				<br><br><br>
			</td>
			<td width="20">
			<td valign="top" align="right">
				<form action="memberListDeleteServlet" method="get">
					<c:set var="user" value="${user}" scope="session"/>
					<input type="submit" value="Hapus akun">
				</form>
				<!-- hapus akun -->
				<br>
				<form action="memberListEditServlet" method="get">
					<c:set var="user" value="${user}" scope="session"/>
					<input type="submit" value="Edit akun">
				</form>
				<!-- edit akun -->
				<br>
				<form action="memberListViewMemberServlet" method="get">
					<c:set var="user" value="${user}" scope="session"/>
					<input type="submit" value="Lihat member">
				</form>
				<!-- Lihat member -->
			</td>
		</tr>
 	</table>
</body>
</html>