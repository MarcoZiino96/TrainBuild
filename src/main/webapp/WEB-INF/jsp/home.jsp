<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Train</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css"> 
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/home.js"></script> 

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
					<label for="sigla">Sigla</label> 
					<div id="siglaError" class="message"></div>
					<input type="text" id="sigla"name="sigla" required onkeyup="validateSigla()">
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