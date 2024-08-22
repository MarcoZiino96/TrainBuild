<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TrainBuild</title>
<link rel="icon" href="${pageContext.request.contextPath}\resources\img\favicon.png" type="image/x-icon">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/miePrenotazioni.css">

</head>
<body>

	<jsp:include page="header.jsp" />


	<div class="containerPrenota">


		<c:if test="${not empty prenotazioni}">
			<c:forEach var="prenotazione" items="${prenotazioni}">



				<div class="cardPrenota">

					<div class="boxImg">
						<div class="imageContainer"></div>
						<div id="treno-data"
							data-compagnia="${prenotazione.vagonePasseggeri.treno.compagnia}"></div>
					</div>

					<div class="boxText">
						<div class="boxProperty">
							<h5>Compagnia:
								${prenotazione.vagonePasseggeri.treno.compagnia}</h5>
							<h5>Sigla:${prenotazione.vagonePasseggeri.treno.sigla}</h5>
						</div>
						<div class="boxProperty">
							<h5>Codice Treno:
								${prenotazione.vagonePasseggeri.treno.compagnia}-${prenotazione.vagonePasseggeri.treno.id}</h5>
						</div>
						<div class="boxProperty">
							<h5>CoordinatePosto: ${prenotazione.coordinatePosto}</h5>
						</div>
					</div>


				</div>

			</c:forEach>
		</c:if>

		<c:if test="${empty prenotazioni }">
			<div class=empty>
				<h3>Ancora non hai effettuato nessuna prenotazione</h3>
			</div>
		</c:if>
	</div>
<jsp:include page="footer.jsp" />
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
</body>
</html>