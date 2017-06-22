<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="user" scope="request"
class="com.shaulabalqis.memberList.memberList"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
<table border="0">
<tr>
<td bgcolor="yellow"> 
<table border="0">
<tr>
<td>
<br>
Nama<br><br>
Password<br><br>
Alamat<br><br>
Tanggal Lahir<br>(yyyy-mm-dd)<br><br>
Nomor Telepon<br><br>
Email<br><br><br><br><br>
<br><br><br>
</td>
<td>
<form action="memberListServlet" method="post">
<br>
<jsp:getProperty property="nama" name="user"/><input type="text" name="nama">
<br><br>
<jsp:getProperty property="password" name="user"/><input type="text" name="password">
<br><br>
<input type="text" name="alamat">
<br><br>
<jsp:getProperty property="tanggalLahir" name="user"/><input type="text" name="tanggalLahir">
<br>
<br><br>
<jsp:getProperty property="telepon" name="user"/><input type="text" name="telepon">
<br><br>
<jsp:getProperty property="email" name="user"/><input type="text" name="email">
<br><br><br>
<input type="submit" value="Daftar">
<br><br><!--  < % 	String message=(String)request.getAttribute("getMessageSignUp()"); 
			if (message.isEmpty()==false)
	 			out.print(message);
 		%> -->
<br><br><br>
</form>
</td>
</tr>
</table>
</td>
<td width="10"><td>
<td>
<table border="0" >
<tr>
<td> <table bgcolor="pink" >
<tr>
<td>
<br>
Nama<br><br>
Password<br><br><br>
<br><br><br>
</td>
<td>
<form action="memberListServlet" method="get">
<br>
<jsp:getProperty property="nama" name="user"/><input type="text" name="nama">
<br><br>
<jsp:getProperty property="password" name="user"/><input type="text" name="password">
<br><br><br>
<input type="submit" value="Masuk">
<br><br><br>
</form>
</td>
</tr>
</table>
</td>
</tr>
<tr><td height ="210"></td></tr>
</table>
</td>
</tr>
</table>
</body>
</html>