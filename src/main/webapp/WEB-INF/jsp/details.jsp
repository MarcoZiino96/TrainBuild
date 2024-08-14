<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>

<style>
* {
	box-sizing: border-box;
}

body {
	padding: 0;
	background-color: #2f1847;
	margin: 0;
}

.boxCard {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.card {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin: 10px auto;
	margin-top: 60px;
	width: 600px;
	height: 600px;
	padding: 60px;
	background-color: #fafafa;
	border: 1px solid #dee2e6;
	border-radius: 8px;
	box-shadow: 0 0 15px 8px rgba(255, 255, 255, 0.2);
	font-family: Arial, sans-serif;
	color: #2f1847;
	margin-bottom: 20px;
}

.titleCard h2 {
    font-size: 22px; 
    color: #343a40;
    margin-bottom: 35px; 
}

.property {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px; 
    padding: 10px 0; 
}



.formOrder {
	text-align: center;
	margin: 30px;
}

<!--
Stile rating voto -->.star-rating {
	display: flex;
	direction: rtl;
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

.action-buttons {
	display: flex;
	align-items: center;
	justify-content: space-between;
	gap: 10px;
}

.action-buttons form {
	margin: 0;
}

.action-buttons button {
	margin: 0;
	padding: 5px 10px;
	font-size: 14px;
	cursor: pointer;
}

.delete {
	border-radius: 30px;
	background-color: red;
}

.modifica {
	border-radius: 30px;
	background-color: gold;
}

.text-center {
	display: flex;
	align-items: center;
	justify-content: center;
}

.property {
	display: flex;
	justify-content: space-between;
	margin-bottom: 10px;
}

.property label {
	font-weight: bold;
	color: #343a40;
	margin-right: 5px;
}

.property span {
	color: #495057;
}

.property:last-child {
	margin-bottom: 0;
}

.boxCard {
	display: flex;
	justify-content: center;
	margin-top: 6rem;
}

.hidden {
	display: none;
}

.form-container {
	display: flex;
	justify-content: center;
	padding: 20px;
}

.form-group {
	display: flex;
	flex-direction: column;
}

.form-group label {
	font-weight: bold;
	color: #343a40;
	margin-bottom: 5px;
}

.form-group input, .form-group select {
	padding: 10px;
	border: 1px solid #ced4da;
	border-radius: 4px;
	font-size: 16px;
}

.text-center {
	display: flex;
	justify-content: center;
}

#invia-btn {
	background-color: #28a745;
	color: #ffffff;
	border: none;
	padding: 10px 10px;
	font-size: 16px;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s;
}


 


.btn-success {
	background-color: #28a745;
	color: #ffffff;
	border: none;
	padding: 10px 20px;
	font-size: 16px;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.btn-success:hover {
	background-color: #218838;
}
</style>
<script>
	function confermaEliminazione() {
		return confirm("Sei sicuro di voler eliminare questo treno?");
	}

	function toggleForm() {
		var form = document.getElementById("modificaTrenoForm");
		form.classList.toggle("hidden");
	}
</script>
</head>
<body>

	<jsp:include page="header.jsp" />
	
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

	<div class="boxCard">
		<div class="card">

			<div class="titleCard">
				<h2>Dettagli del treno:</h2>
			</div>
			
			<div class="property">
				<label>Sigla: </label> <span>${treno.sigla}</span>
			</div>
			<div class="property">
				<label>Compagnia: </label> <span>${treno.compagnia}</span>
			</div>
			<div class="property">
				<label>Prezzo: </label> <span>${treno.prezzo}</span>
			</div>
			<div class="property">
				<label>Peso: </label> <span>${treno.peso}</span>
			</div>
			<div class="property">
				<label>Lunghezza: </label> <span>${treno.lunghezza}</span>
			</div>
			<div class="property">
				<label>Utente: </label> <span>${utente.username}</span>
			</div>
			<div class="boxVoto">
				<form:form modelAttribute="voto" action="voto" method="post">
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
				
				<div>
					<button id= "invia-btn" type="submit">Invia</button>
				</form:form>
			</div>
			<div class="property">
				<c:if test="${treno.utente.id == utente.id}">
					<div class="action-buttons delete">
						<form action="eliminaTreno" method="post"
							onsubmit="return confermaEliminazione()" style="display: inline;">
							<input type="hidden" name="trenoId" value="${treno.id}" />
							<button class="delete" type="submit">Elimina</button>
						</form>
					</div>
					<button class="modifica" onclick="toggleForm()">Modifica</button>

					<form action="duplicaTreno" method="post">
						<input type="hidden" name="trenoId" value="${treno.id}" />
						<button type="submit">Duplica</button>
					</form>
				</c:if>

			</div>

		</div>
	</div>



	<c:if test="${treno.utente.id == utente.id}">
		<div class="form-container">

			<form id="modificaTrenoForm" class="hidden" action="modificaTreno"
				method="post">
				<input type="hidden" name="trenoId" value="${treno.id}" />

				<div class="form-group">
					<label for="sigla">Sigla</label> <input type="text" id="sigla"
						name="sigla" value="${treno.sigla}" required>
				</div>

				<div class="form-group">
					<label for="compagnia">Compagnia</label> <select id="compagnia"
						name="compagnia" required>
						<option value="FR"
							<c:if test="${treno.compagnia == 'FR'}">selected</c:if>>Frecciarossa(FR)</option>
						<option value="IT"
							<c:if test="${treno.compagnia == 'IT'}">selected</c:if>>Italo(IT)</option>
						<option value="TN"
							<c:if test="${treno.compagnia == 'TN'}">selected</c:if>>Trenord(TN)</option>
					</select>
				</div>

				<div class="text-center">
					<button type="submit" class="btn-success">Modifica Treno</button>
				</div>
			</form>
		</div>

	</c:if>

</body>
</html>