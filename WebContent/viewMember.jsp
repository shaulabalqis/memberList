<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Daftar member</title>
</head>
<body>
<h1>Member yang terdaftar : </h1>
<table border="0">
	<tr>
		<td>
		<form action="memberListViewMemberServlet" method="get">
		<c:set var="k" value="${jumlahMember}" scope="request"/>
			<c:forEach var="i" begin="0" end="k">
			<c:set var="member" value="${memberTotal[i]}" scope="request"/>
			<jsp:getProperty property="nama" name="member"/> 
			<br>
			</c:forEach>
		</form>
		<!-- list member -->
		
		</td>
		<td width="10"></td>
		<td>
		<!-- tambah member -->
		<form action="memberListAddMemberServlet" method="get">
		
		</form>
		
		</td>
		
	</tr>

</table>

</body>
</html>