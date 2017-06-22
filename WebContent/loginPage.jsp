<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<table border="0">
<tr><td>
<!--   nama, alamat,... -->

Nama<br><br>
Password<br><br>
Alamat<br><br>
Tanggal Lahir<br>(yyyy-mm-dd)<br><br>
Nomor Telepon<br><br>
Email<br><br>
<br><br><br>
</td>
<td>
<form action="memberListLogInServlet" method="get">
<% String nama = (String)request.getAttribute("user.getNama()");%>
<%=nama%><br><br>
<% String password = (String)request.getAttribute("user.getPassword()");%>
<%=password%><br><br>
<% String alamat = (String)request.getAttribute("user.getAlamat()");%>
<%=alamat%><br><br>
<% String tanggalLahir = (String)request.getAttribute("user.getTanggalLahir()");%>
<%=tanggalLahir%><br><br><br>
<% String telepon = (String)request.getAttribute("user.getTelepon()");%>
<%=telepon%><br><br>
<% String email = (String)request.getAttribute("user.getEmail()");%>
<%=email%><br><br>
<!-- var nama, alamat,... -->
</form>
<br><br><br>
</td>
<td width="500">
<!-- hapus akun -->
</td>
</tr>
<tr>
<td width="400">
<!-- tombol edit -->
</td>
<td width="400">
<!-- tombol hapus data -->
</td>

</tr>
</table>
</body>
</html>