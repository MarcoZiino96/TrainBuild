<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CreateYourTrain</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg">
			<div class="container">
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarContent" aria-controls="navbarContent"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Chi siamo</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Contatti</a></li>
						<c:if test="${not empty sessionScope.utente}">
							<li class="nav-item"><a href="order" class="nav-link">Ricerca Ordinamento</a></li>
							<li class="nav-item"><a href="prenota" class="nav-link">Prenota</a></li>
							<li class="nav-item"><a href="miePrenotazioni" class="nav-link">Mie Prenotazioni</a></li>
						</c:if>
					</ul>
					<div class="d-flex align-items-center">
						<c:if test="${not empty sessionScope.utente}">
							<span class="user-info">${sessionScope.utente.nome} ${sessionScope.utente.cognome}</span>
							<form:form action="logout" method="post" class="form-inline">
								<input type="submit" value="Logout" class="btn btn-primary" />
							</form:form>
						</c:if>
						<c:if test="${empty sessionScope.utente}">
							<a href="formlogin" class="btn btn-outline-primary me-2">Login</a>
							<a href="preRegister" class="btn btn-primary">Registrati</a>
						</c:if>
					</div>
				</div>
			</div>
		</nav>
	</header>

	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
