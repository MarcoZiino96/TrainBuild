<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Train</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 600px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

h2 {
	margin-bottom: 20px;
	color: #333;
}

form {
	margin-bottom: 30px;
}

.form-group {
	margin-bottom: 15px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
}

.form-group input, .form-group select {
	width: 100%;
	padding: 8px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

.btn {
	display: inline-block;
	padding: 10px 20px;
	color: #fff;
	background-color: green;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	text-decoration: none;
}

.btn:hover {
	background-color: #0056b3;
}

.train-details .info {
	margin-bottom: 10px;
	padding: 10px;
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	border-radius: 5px;
}

.info strong {
	display: inline-block;
	width: 120px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<h2>Crea Treno</h2>

		<c:if test="${not empty errorMessage}">
			<div class="error-message">
				<p>${errorMessage}</p>
			</div>
		</c:if>
		<form action="newTrain" method="post">
			<div class="form-group">
				<label for="sigla">Sigla</label> <input type="text" id="sigla"
					name="sigla" required>
			</div>
			<div class="form-group">
				<label for="compagnia">Compagnia</label> <select id="compagnia"
					name="compagnia" required>
					<option value="FR">Frecciarossa(FR)</option>
					<option value="IT">Italo(IT)</option>
					<option value="TN">Trenord(TN)</option>
				</select>
			</div>
			<button type="submit" class="btn">Crea Treno</button>
		</form>

		<c:if test="${empty sessionScope.utente}">

			<div class="train-details">
				<h2>Dettagli Treno</h2>
				<div class="info">
					<strong>Sigla:</strong> ${treno.sigla}
				</div>
				<div class="info">
					<strong>Compagnia:</strong> ${treno.compagnia}
				</div>
				<div class="info">
					<strong>Prezzo:</strong> ${treno.prezzo}
				</div>
				<div class="info">
					<strong>Treno:</strong> ${treno.peso}
				</div>
				<div class="info">
					<strong>lunghezza:</strong> ${treno.lunghezza}
				</div>
				<div class="info">
					<strong>Utente:</strong>
					<c:choose>
						<c:when test="${treno.utente != null}">
                            ${treno.utente.nome} ${treno.utente.cognome}
                        </c:when>
						<c:otherwise>
                            Nessun utente associato
                        </c:otherwise>
					</c:choose>
				</div>
			</div>
	</div>
	</c:if>
</body>
</html>