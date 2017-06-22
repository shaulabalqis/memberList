<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>

<form action="memberListServlet" method="post">
Nama 			: <jsp:getProperty property="nama" name="user"/><input type="text" name="nama">
<br><br>
Password		: <jsp:getProperty property="password" name="user"/><input type="text" name="password">
<br><br>
Alamat			: <input type="text" name="alamat">
<br><br>
Tanggal Lahir	: <jsp:getProperty property="tanggalLahir" name="user"/><input type="text" name="tanggalLahir">
<br>
(yyyy-mm-dd)
<br><br>
Nomor Telepon 	: <jsp:getProperty property="telepon" name="user"/><input type="text" name="telepon">
<br><br>
Email 			: <jsp:getProperty property="email" name="user"/><input type="text" name="email">
<br><br><br>
                  <input type="submit" value="daftar">
</form>

</body>
</html>