<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="user" scope="request"
class="com.shaulabalqis.memberList.memberList"></jsp:useBean>
<html>
<head>
<style type="text/css" media="all">
h2{
color: #36C;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body bgcolor="#c5ecc5">

<table border="0" align="center">
	<tr>
		<td align="center"><h2>Belum punya akun?</h2></td>
		<td></td>
		<td align="center"><h2>User lama?</h2></td>
	</tr>
	<tr>
		<td bgcolor="#f9f465" width="45%" > 
			<table border="0">
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
						<form action="memberListServlet" method="post">
							<!-- <jsp:getProperty property="nama" name="user"/> --><input type="text" name="nama"><br><br>
							<!-- <jsp:getProperty property="password" name="user"/> --><input type="text" name="password"><br><br>
							<!-- <jsp:getProperty property="alamat" name="user"/> --><input type="text" name="alamat"><br><br>
							<!-- <jsp:getProperty property="tanggalLahir" name="user"/> --><input type="text" name="tanggalLahir"><br><br><br>
							<!-- <jsp:getProperty property="telepon" name="user"/> --><input type="text" name="telepon"><br><br>
							<!-- <jsp:getProperty property="email" name="user"/> --><input type="text" name="email"><br><br><br>
							<input type="submit" value="Daftar"><br><br>
							<br><br>
							<c:set var="message" value="${messageSignUp}" scope="session"/>
							<c:out value="${message}" />
							<c:if test="${message.isEmpty()==false}">
								<script type="text/javascript">
									alert("${message}");
								</script>
							</c:if>
						</form>
					</td>
				</tr>
			</table>
		</td>
		<td width="10%"></td>
		<td width = "45%">
			<table border="0" align="center">
				<tr>
					<td> 
						<table border="0" bgcolor="#a2d9e3"  >
							<tr>
								<td>
									<br>Nama<br><br>
									Password<br><br><br><br><br><br><br>
								</td>
								<td>
									<form action="memberListLogInServlet" method="post">
									<c:set var="newlyLogIn" value="$[true]" scope="session"/>
										<br><!-- <jsp:getProperty property="nama" name="user"/> --><input type="text" name="nama"><br><br>
										<!-- <jsp:getProperty property="password" name="user"/> --><input type="text" name="password"><br><br><br>
										<input type="submit" value="Masuk"><br><br><br><br>
									</form>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="180"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>