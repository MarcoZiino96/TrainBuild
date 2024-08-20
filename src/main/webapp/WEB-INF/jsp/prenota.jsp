<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TrainBuild</title>
<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.png" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/prenota.css">
<script>
	document
			.addEventListener(
					'DOMContentLoaded',
					function() {

						var trenoImageContainers = document
								.querySelectorAll('.imageContainer');

						var trenoDataElements = document
								.querySelectorAll('#treno-data');

						if (trenoImageContainers.length === trenoDataElements.length) {
							trenoDataElements
									.forEach(function(dataElement, index) {
										var trenoCompagnia = dataElement
												.getAttribute('data-compagnia');
										var trenoImage = document
												.createElement('img');
										trenoImage.alt = 'Immagine Treno';
										trenoImage.style.maxWidth = '250px';
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

										// Aggiungi l'immagine al container appropriato
										if (trenoImageContainers[index]) {
											trenoImageContainers[index]
													.appendChild(trenoImage);
										}
									});
						}
					});
</script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="containerPrenota">

		<c:if test="${not empty treni}">	
			<c:if test="${not empty errorMessage}">
				<div class="boxDanger">
					<p>
						<c:out value="${errorMessage}" />
					</p>
				</div>
			</c:if>
			<c:if test="${not empty messaggio}">
				<div class="boxSuccess">
					<p>
						<c:out value="${messaggio}" />
					</p>
				</div>
			</c:if>

			<div class="containerCard">
				<c:forEach var="treno" items="${treni}">
					<div class="cardPrenota">

						<div class="boxImg">
							<div class="imageContainer"></div>
							<div id="treno-data" data-compagnia="${treno.compagnia}"></div>
						</div>
						<div class="boxText">
							<div class="boxProperty">
								<h5>Compagnia: ${treno.compagnia}</h5>
								<h5>Sigla:${treno.sigla}</h5>
							</div>
							<div class="boxProperty">
								<h5>Lunghezza: ${treno.lunghezza} m</h5>
								<h5>Peso:${treno.peso} Kg</h5>
							</div>
							<div class="boxProperty">
								<h5>Prezzo: ${treno.prezzo} €</h5>
								<h5>Voto:${treno.mediaVoti}</h5>
							</div>
							<div class="boxProperty">
								<form:form modelAttribute="prenotazione" action="prenota"
									method="post">
									<form:hidden path="vagoneId" value="${prenotazione.vagoneId}" />
									<form:hidden path="utenteId" value="${sessionScope.utente.id}" />
									<input type="hidden" name="trenoId" value="${treno.id}" />
									<button class="submitBtn" type="submit">Prenota</button>
								</form:form>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
  
		<c:if test="${empty treni }">
			<h3 class="empty">
				Non ci sono treni con vagoni passeggeri per poter prenotare un posto!!
			</h3>
		</c:if>
	</div>

</body>
</html>
