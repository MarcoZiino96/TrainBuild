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
</head>
<body>
	<header>
		<nav class="navbar">
			<div class="container">
				<ul class="navbar-nav">
					<li class="nav-item">
					<a class="nav-link" href="home">Home</a>
					</li>
					<c:if test="${not empty sessionScope.utente}">
						<li class="nav-item">
						<a class="nav-link" href="order">Ricerca
								Treno
						</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="prenota">Prenota</a></li>
						<li class="nav-item"><a class="nav-link" href="miePrenotazioni">Mie
								Prenotazioni</a></li>
						<li class="nav-item"><span class="username">${sessionScope.utente.username}</span>
						</li>
						<li class="nav-item">
							<div class="logout-container">
								<form action="logout" method="post">
									<input type="submit" value="Logout" class="logoutBtn">
								</form>
							</div>
						</li>
					</c:if>
					<c:if test="${empty sessionScope.utente}">
						<li class="nav-item"><a href="formlogin" class="nav-link">Login</a></li>
						<li class="nav-item"><a href="preRegister" class="nav-link">Registrati</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
</body>
</html>