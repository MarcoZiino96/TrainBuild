<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Lista Treni</title>
<style>
@charset "UTF-8";

body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 40px;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

tr:hover {
	background-color: #f1f1f1;
}

.message {
	text-align: center;
	margin: 20px;
	padding: 10px;
	border: 1px solid #ccc;
	background-color: #f2f2f2;
}

.error {
	border-color: red;
	color: red;
}

.success {
	border-color: green;
	color: green;
}
</style>


</head>

<body>


	<jsp:include page="header.jsp" />

	<div class="titleOrder">
		<h2>Ricerca un treno con l'ordinamento che preferisci</h2>
	</div>

	<c:if test="${not empty successSave}">
		<div style="color: green;">${successSave}</div>
	</c:if>

	<c:if test="${not empty successModifica}">
		<div style="color: green;">${successModifica}</div>
	</c:if>

	<form class="formOrder">
		<label for="ordinamento">Ordina per:</label> <select id="ordinamento"
			name="ordinamento">
			<option value="compagnia">Compagnia</option>
			<option value="sigla">Sigla</option>
			<option value="lunghezza">Lunghezza</option>
			<option value="peso">Peso</option>
			<option value="prezzo">Prezzo</option>
		</select> <label for="direction">Direzione:</label> <select id="direction"
			name="direction">
			<option value="ASC">Crescente</option>
			<option value="DESC">Decrescente</option>
		</select>

		<button type="submit">Cerca</button>
	</form>

	<c:if test="${not empty errorMessage}">
		<div class="message error">
			<p>${errorMessage}</p>
			<c:if test="${not empty errorSigla}">
				<p>Sigla: ${errorSigla}</p>
			</c:if>
			<c:if test="${not empty errorSuggerimento}">
				<p>Suggerimento: ${errorSuggerimento}</p>
			</c:if>
			<c:if test="${not empty errorSiglaSuggerita}">
				<p>Sigla Suggerita: ${errorSiglaSuggerita}</p>
			</c:if>
		</div>
	</c:if>
	<c:if test="${not empty successMessage}">
		<div class="message success">
			<p>${successMessage}</p>
		</div>
	</c:if>

	<table>
		<thead>
			<tr>
				<th>Compagnia</th>
				<th>Sigla</th>
				<th>Lunghezza</th>
				<th>Peso</th>
				<th>Prezzo</th>
				<th>Utente</th>
				<th>Voto</th>
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
					<td>${treno.mediaVoti}</td>
					<td>
						<!-- Usa un form per inviare una richiesta POST -->
						<form action="selectDetails" method="post">
							<input type="hidden" name="id" value="${treno.id}" />
							<button type="submit">Dettagli</button>
						</form>
				</tr>

			</c:forEach>

		</tbody>
	</table>
</body>
</html>
