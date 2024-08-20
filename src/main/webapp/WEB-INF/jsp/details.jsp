<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/details.css">
 <!--  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/details.js"></script> -->



<script>
	function confermaEliminazione() {
		return confirm("Sei sicuro di voler eliminare questo treno?");
	}

	function toggleForm() {
		var form = document.getElementById("modificaTrenoForm");
		form.classList.toggle("hidden");
	}
</script>

<script>
document.addEventListener('DOMContentLoaded', function() {
    var trenoImageContainer = document.getElementById('treno-image-container');
    var trenoData = document.getElementById('treno-data');
    var trenoCompagnia = trenoData.getAttribute('data-compagnia');
    
    console.log('Compagnia:', trenoCompagnia); 

    var trenoImage = document.createElement('img');
    trenoImage.alt = 'Immagine Treno';
    trenoImage.style.maxWidth = '100%';
    trenoImage.style.height = 'auto';

    switch(trenoCompagnia) {
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
});
</script>



</head>

<body>

	<jsp:include page="header.jsp" />

	<div class="btn-navbar">
		<div class="btn-navbar-content">



			<button class="icon-button" onclick="toggleForm()" title="Modifica">
				<i class="fas fa-edit"></i>
			</button>

			<form action="duplicaTreno" method="post">
				<input type="hidden" name="trenoId" value="${treno.id}" />
				<button class="icon-button" type="submit" title="Duplica">
					<i class="fas fa-copy"></i>
				</button>
			</form>

			<form action="eliminaTreno" method="post"
				onsubmit="return confermaEliminazione()">
				<input type="hidden" name="trenoId" value="${treno.id}" />
				<button class="icon-button" id="icon-button-delete" type="submit"
					title="Elimina">
					<i class="fas fa-trash-alt"></i>
				</button>
			</form>

		</div>
	</div>


	<div class="boxCard">
		<div class="card">

			<div class="titleCard">
				<h2>Dettagli del treno:</h2>
			</div>



			<div id="treno-image-container"
				style="text-align: center; margin-bottom: 20px;"></div>

			<div id="treno-data" data-compagnia="${treno.compagnia}"></div>


			<div class="property-list">

				<div class="sigla-compagnia-property">
					<div class="property">
						<label>SIGLA: </label> <span>${treno.sigla}</span>
					</div>
					<div class="property">
						<label>COMPAGNIA: </label> <span>${treno.compagnia}</span>
					</div>
				</div>

				<div class="lunghezza-peso-property">
					<div class="property">
						<label>LUNGHEZZA: </label> <span>${treno.lunghezza}</span>
					</div>
					<div class="property">
						<label>PESO: </label> <span>${treno.peso}</span>
					</div>
				</div>

				<div class="prezzo-utente-property">
					<div class="property">
						<label>PREZZO: </label> <span>${treno.prezzo}</span>
					</div>
					<div class="property">
						<label>UTENTE: </label> <span>${utente.username}</span>
					</div>
				</div>

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

					<div id="btn-invia">
						<button id="invia-btn" type="submit">Invia</button>
					</div>
				</form:form>
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
									<c:if test="${treno.compagnia == 'FR'}">selected</c:if>>Frecciarossa
									(FR)</option>
								<option value="IT"
									<c:if test="${treno.compagnia == 'IT'}">selected</c:if>>Italo
									(IT)</option>
								<option value="TN"
									<c:if test="${treno.compagnia == 'TN'}">selected</c:if>>Trenord
									(TN)</option>
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