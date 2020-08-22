<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
	font-family:Tahoma, Geneva, sans-serif;
	border-collapse: collapse;
}
table td{
	border:1px solid #ddd;
}
table tr:nth-child(even){
	background-color: #f2f2f2;
}
table tr:hover{
	background-color: #ddd;
}
</style>
</head>
<body>
<form action="AnalizadorSintactico">
	<label>Campo1:</label>
	<br/>
	<textarea name="campo1" rows="10" cols="50"></textarea>
	<br/>
	<input type="submit" value="Enviar">
	<c:if test="${not empty sessionScope.lista1}">
		<br/>
		Grilla Resultado:
		<br/>
		<table id="tabla">
			<tbody>
			<c:forEach items = "${sessionScope.lista1}" var = "elemento"  varStatus="current">
				<c:forEach items = "${elemento}" var = "mapa"  varStatus="current">
				<tr>
					<td>${mapa.key}</td>
					<td>${mapa.value}</td>
				</tr>
				</c:forEach>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</form>
</body>
</html>