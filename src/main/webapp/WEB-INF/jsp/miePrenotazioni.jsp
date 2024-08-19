<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body {
	background-color: #2F1847;
}

.containerPrenota {
	padding-top: 30px;
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	gap: 30px;
}

.cardPrenota {
	box-sizing: border-box;
	width: 550px;
	background-color: #1D1D1D;
	color: #bfa458;
	padding: 10px;
	font-weight: bold;
	border-radius: 20px;
	box-shadow: 0 0 15px 8px rgba(205, 164, 52, 0.2);
	display: flex;
	gap: 10px;
}

.boxProperty {
	display: flex;
	justify-content: space-around;
}

.boxText {
	width: 100%;
}

.boxDanger {
	font-weight: bold;
	color: red;
}

.boxSuccess {
	font-weight: bold;
	color: green;
}

.submitBtn {
	padding: 10px 20px;
	background-color: #2f1847;
	color: #e0c680;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	transition: transform 0.3s ease;
}

.submitBtn:hover {
	background-color: #bfa458;
	color: white;
	transform: scale(1.1);
}
</style>


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



		<c:forEach var="prenotazione" items="${prenotazioni}">



			<div class="cardPrenota">
			
			<div class="boxImg">
					<div class="imageContainer"></div>
					<div id="treno-data" data-compagnia="${prenotazione.vagonePasseggeri.treno.compagnia}"></div>
				</div>
				
				<div class="boxText">
					<div class="boxProperty">
						<h5>Compagnia: ${prenotazione.vagonePasseggeri.treno.compagnia}</h5>
						<h5>Sigla:${prenotazione.vagonePasseggeri.treno.sigla}</h5>
					</div>
					<div class="boxProperty">
					<h5>Codice Treno:${prenotazione.vagonePasseggeri.treno.id}</h5>
					</div>
					<div class="boxProperty">
						<h5>CoordinatePosto: ${prenotazione.coordinatePosto}</h5>
					</div>
				</div>


			</div>

		</c:forEach>
	</div>



</body>
</html>