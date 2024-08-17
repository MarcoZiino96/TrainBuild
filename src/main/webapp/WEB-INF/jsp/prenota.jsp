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
body{
background-color: #2F1847;
}
.containerPrenota {
    padding-top:30px;
    display: flex;
    flex-direction:column;
    flex-wrap: wrap;
    align-content: center;
    gap:10px;
}

.cardPrenota {
    box-sizing: border-box;
    width:50%;
    background-color: #1D1D1D;
    color: #bfa458;
    padding: 10px;
    font-weight: bold;
    border-radius: 50px;
    box-shadow: 0 0 15px 8px rgba(205, 164, 52, 0.2);
    display: flex;
    justify-content:center;
    gap: 10px;
}

.boxProperty {
	display: flex;
	justify-content: space-between;
}
</style>


<script>
	document
			.addEventListener(
					'DOMContentLoaded',
					function() {
						// Seleziona tutti gli elementi con la classe 'imageContainer'
						var trenoImageContainers = document
								.querySelectorAll('.imageContainer');

						// Seleziona tutti gli elementi con l'id 'treno-data' (assumendo che abbiano lo stesso ordine delle card)
						var trenoDataElements = document
								.querySelectorAll('#treno-data');

						// Verifica che ci siano gli stessi numeri di imageContainers e trenoDataElements
						if (trenoImageContainers.length === trenoDataElements.length) {
							trenoDataElements
									.forEach(function(dataElement, index) {
										var trenoCompagnia = dataElement
												.getAttribute('data-compagnia');
										var trenoImage = document
												.createElement('img');
										trenoImage.alt = 'Immagine Treno';
										trenoImage.style.maxWidth = '100%';
										trenoImage.style.height = '100%';

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
           </div>
			</div>
			
		</c:forEach>
	</div>



</body>
</html>