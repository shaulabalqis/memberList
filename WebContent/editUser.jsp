<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<br><br>
<table border="0" align="center">
				<tr>
					<td>
						Nama<br><br>		
						Password<br><br>
						Alamat<br><br>
						Tanggal Lahir<br>(yyyy-mm-dd)<br><br><br>
						Nomor Telepon<br><br>
						Email<br><br><br><br><br><br><br>			
					</td>
					<td>
						<form action="memberListEditServlet" method="post">
							<!-- <jsp:getProperty property="nama" name="user"/> --><input type="text" name="nama" value="<jsp:getProperty property="nama" name="user"/>"><br><br>
							<!-- <jsp:getProperty property="password" name="user"/> --><input type="text" name="password" value="<jsp:getProperty property="password" name="user"/>"><br><br>
							<!-- <jsp:getProperty property="alamat" name="user"/> --><input type="text" name="alamat" value="<jsp:getProperty property="alamat" name="user"/>"><br><br>
							<!-- <jsp:getProperty property="tanggalLahir" name="user"/> --><input type="text" name="tanggalLahir" value="<jsp:getProperty property="tanggalLahir" name="user"/>"><br><br><br>
							<!-- <jsp:getProperty property="telepon" name="user"/> --><input type="text" name="telepon" value="<jsp:getProperty property="telepon" name="user"/>"><br><br>
							<!-- <jsp:getProperty property="email" name="user"/> --><input type="text" name="email" value="<jsp:getProperty property="email" name="user"/>"><br><br><br>
							<input type="submit" value="Perbaharui"><br><br>
							<c:set var="user" value="${user}" scope="session"/>
							<br><br>
						</form>
					</td>
				</tr>
			</table>

</body>
</html>