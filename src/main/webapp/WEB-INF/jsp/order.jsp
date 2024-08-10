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

.titleOrder {
	text-align: center;
}

.titleOrder h2 {
	margin: 20px;
	padding-top: 40px;
}

.formOrder {
	text-align: center;
	margin: 30px;
}

<!--
Stile rating voto -->.star-rating {
	display: flex;
	direction: ltr;
}

.star-rating input {
	display: none;
}

.star-rating label {
	font-size: 24px;
	color: #ccc;
	cursor: pointer;
}

.star-rating input:checked ~ label {
	color: gold;
}

.star-rating label:hover, .star-rating label:hover ~ label {
	color: gold;
}

.star-rating input:checked+label, .star-rating input:checked+label ~
	label {
	color: gold;
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


					<td><form:form modelAttribute="voto" action="voto"
							method="post">
							<form:hidden path="id" />
							<form:hidden path="trenoId" value="${treno.id}" />
							<form:hidden path="utenteId" value="${sessionScope.utente.id}" />

							<div class="star-rating">

								<form:radiobutton path="voto" id="star5-${treno.id}" value="5" />
								<label for="star5-${treno.id}" title="5 stelle">&#9733;</label>

								<form:radiobutton path="voto" id="star4-${treno.id}" value="4" />
								<label for="star4-${treno.id}" title="4 stelle">&#9733;</label>

								<form:radiobutton path="voto" id="star3-${treno.id}" value="3" />
								<label for="star3-${treno.id}" title="3 stelle">&#9733;</label>

								<form:radiobutton path="voto" id="star2-${treno.id}" value="2" />
								<label for="star2-${treno.id}" title="2 stelle">&#9733;</label>

								<form:radiobutton path="voto" id="star1-${treno.id}" value="1" />
								<label for="star1-${treno.id}" title="1 stella">&#9733;</label>

							</div>
							<button type="submit">Invia</button>
						</form:form></td>
				</tr>

			</c:forEach>

		</tbody>
	</table>



</body>
</html>