<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>TrainBuild</title>
<link rel="icon"
	href="${pageContext.request.contextPath}\resources\img\favicon.png"
	type="image/x-icon">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/home.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/home.js"></script>


</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="containerHome">
		<h2>Crea il tuo Treno:</h2>

		<c:if test="${not empty errorMessage}">
			<div class="boxDanger">

				<p>
					<strong>Errore: Questa sigla è errata --></strong>
					<c:out value="${errorMessage}" />
				</p>
			</div>
		</c:if>
		<c:if test="${not empty errorSigla}">
			<div class="boxDanger">
				<p>
					<strong>Sigla:</strong>
					<c:out value="${errorSigla}" />
				</p>
			</div>
		</c:if>

		<c:if test="${not empty errorSuggerimento}">
			<div class="boxSuccess">
				<p>
					<strong>Suggerimento:</strong>
					<c:out value="${errorSuggerimento}" />
				</p>
			</div>

		</c:if>
		<c:if test="${not empty errorSiglaSuggerita}">
			<div class="boxSuccess">
				<p>
					<strong>Sigla Suggerita:</strong>
					<c:out value="${errorSiglaSuggerita}" />
				</p>
			</div>

		</c:if>
		<div class="box">
			<form class="formHome" action="newTrain" method="post">
				<div class="form-group">
					<label for="sigla">Sigla</label>
					<div id="siglaError" class="message"></div>
					<input type="text" id="sigla" name="sigla"
						onkeyup="validateSigla()">
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

			</form>



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
						<strong>Lunghezza(m):</strong> <span>${treno.lunghezza}</span>
					</div>
				</div>

				<c:if test="${treno.compagnia != null}">
					<div>
						<div id="treno-image-container"></div>

						<div id="treno-data" data-compagnia="${treno.compagnia}"></div>
					</div>
				</c:if>

			</c:if>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script>
document
.addEventListener(
		'DOMContentLoaded',
		function() {
			var trenoImageContainer = document
					.getElementById('treno-image-container');
			var trenoData = document.getElementById('treno-data');
			var trenoCompagnia = trenoData
					.getAttribute('data-compagnia');

			var trenoImage = document.createElement('img');
			trenoImage.alt = 'Immagine Treno';
			trenoImage.style.width = '300px';
			trenoImage.style.height = '200px';
			trenoImage.style.borderRadius = '20px';

			switch (trenoCompagnia) {
			case 'FR':
				trenoImage.src = '${pageContext.request.contextPath}/resources/img/frecciarossa.jpeg';
				break;
			case 'IT':
				trenoImage.src = '${pageContext.request.contextPath}/resources/img/italo.jpeg';
				break;
			case 'TN':
				trenoImage.src = '${pageContext.request.contextPath}/resources/img/trenord.jpeg';
				break;
			default:
				trenoImage.src = '${pageContext.request.contextPath}/resources/img/default.jpg';
			}

			trenoImageContainer.appendChild(trenoImage);
		})
</script>
</body>
</html>