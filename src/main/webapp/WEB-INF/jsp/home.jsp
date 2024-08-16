<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Train</title>

<!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css"> -->

<style>

* {
    box-sizing: border-box;
}

body {
	padding: 0;
	background-color: #2f1847;
	margin: 0;
}

.containerHome {
    max-width: 50%;
    padding: 40px;
    background-color: black;
    border-radius: 8px;
    box-shadow: 0 2px 10px #c62e65;
    color: #e0c680;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin: 10px auto;
    margin-top: 60px;
    box-shadow: 0 0 15px 8px rgba(255, 255, 255, 0.2);
}

.box {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

h2 {
	margin-bottom: 20px;
	
}

form {
	margin-bottom: 30px;
}

.form-group {
	margin: 50px;
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

.btnSubmit {
	text-align: center;
	width: 100%;
}

.submitBtn {
	display: inline-block;
	padding: 10px 20px;
	background-color: #e0c680;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	color: #2f1847;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.submitBtn:hover {
	background-color: #bfa458;
	color: #2f1847;
}

.train-details .info {
	margin-bottom: 10px;
	padding: 10px;
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	border-radius: 5px;
}

.train-details h2 {
	text-align: center;
	width: 100%;
}

.info strong {
	display: inline-block;
	width: 120px;
}
</style> 
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="containerHome">
		<div class="box">
			<h2>Crea il tuo Treno:</h2>

			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger">

					<p>
						<strong>Errore: Questa sigla è errata --></strong>
						<c:out value="${errorMessage}" />
					</p>
				</div>
			</c:if>
			<c:if test="${not empty errorSigla}">
				<div class="alert alert-danger">
					<p>
						<strong>Sigla:</strong>
						<c:out value="${errorSigla}" />
					</p>
				</div>
			</c:if>

			<c:if test="${not empty errorSuggerimento}">
				<div class="alert alert-success">
					<p>
						<strong>Suggerimento:</strong>
						<c:out value="${errorSuggerimento}" />
					</p>
				</div>

			</c:if>
			<c:if test="${not empty errorSiglaSuggerita}">
				<div class="alert alert-success">
					<p>
						<strong>Sigla Suggerita:</strong>
						<c:out value="${errorSiglaSuggerita}" />
					</p>
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
						<option value="FR">Frecciarossa (FR)</option>
						<option value="IT">Italo (IT)</option>
						<option value="TN">Trenord (TN)</option>
					</select>
				</div>

				<div class="btnSubmit">
					<button type="submit" class="submitBtn">Crea Treno</button>
				</div>



				<c:if test="${empty sessionScope.utente}">

					<div class="train-details form-group">
						<h2>Dettagli Treno</h2>
						<div class="info">
							<strong>Sigla:</strong> ${treno.sigla}
						</div>
						<div class="info">
							<strong>Compagnia:</strong> ${treno.compagnia}
						</div>
						<div class="info">
							<strong>Prezzo(€):</strong> ${treno.prezzo}
						</div>
						<div class="info">
							<strong>Peso(Kg):</strong> ${treno.peso}
						</div>
						<div class="info">
							<strong>lunghezza(m):</strong> ${treno.lunghezza}
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

				</c:if>
		</div>
	</div>
</body>
</html>