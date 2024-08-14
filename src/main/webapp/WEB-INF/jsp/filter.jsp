<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Filtra i treni:</title>

<!--  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/filter.css"> -->

<style>
@charset "UTF-8";

body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

th, td {
	border: 1px solid #666666; 
	text-align: left;
	padding: 12px;
	margin-top: 20px;
}

th {
	background-color: #E6E6FA;
	color: #333333;
	text-transform: uppercase; 
    font-weight: bold;
}

tr:nth-child(even) {
	 background-color: #E6E6FA;
}

tr:nth-child(odd) {
    background-color: #F8F8FF; 
}

tr:hover {
	background-color: #f1f1f1;
	background-color: rgba(230, 230, 250, 0.2);
}


.titleFilter {
	text-align: center;
}

.titleFilter h2 {
	margin: 20px;
	padding-top: 40px;
}

.formFilter {
	display: flex;
	justify-content: center; 
	gap: 60px; 
	flex-wrap: wrap;
	margin: 40px;
}

.formFilter form > * {
    margin-bottom: 30px; 
}

.button-container {
	width: 100%; 
	display: flex;
	justify-content: center; 
	margin-top: 20px; 
}

.button {
	padding: 10px 20px; 
	background-color: #4CAF50;
    color: white;
    border:none;
}

</style> 

</head>

<body>

	<jsp:include page="header.jsp" />

	


	<table>
		<thead>
			<tr>
				<th>Compagnia</th>
				<th>Sigla</th>
				<th>Lunghezza</th>
				<th>Peso</th>
				<th>Prezzo</th>
				<th>Utente</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="treno" items="${treni}">
				<tr>
					<td>${treno.compagnia}</td>
					<td>${treno.sigla}</td>
					<td>${treno.lunghezza}</td>
					<td>${treno.peso}</td>
					<td>${treno.prezzo}</td>
					<td>${treno.utente.username}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<img src="${pageContext.request.contextPath}/resources/img/train.png">



</body>
</html>