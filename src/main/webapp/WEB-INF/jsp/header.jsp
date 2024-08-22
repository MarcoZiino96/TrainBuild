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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<header>
		<nav class="navbar">
			<c:if test="${empty sessionScope.utente}">
				
					<ul class="navNoLogin">
						<div class="boxNoLogin">
							<li class=nav-item><img class="imgLogo" alt="logo"
								src="${pageContext.request.contextPath}/resources/img/logo-TrainBuild.png">
							</li>
						</div>
						<div class="boxNoLogin">
							<li class="nav-item"><a class="nav-link" href="home">Home</a>
							</li>
							<li class="nav-item"><a href="formlogin" class="nav-link">Login</a></li>
							<li class="nav-item"><a href="preRegister" class="nav-link">Registrati</a></li>

						</div>
					</ul>
			</c:if>

			<c:if test="${not empty sessionScope.utente}">
				<ul class="navbar-nav">
					<div class="boxLink">
						<li class=nav-item><img class="imgLogo" alt="logo"
							src="${pageContext.request.contextPath}/resources/img/logo-TrainBuild.png">
						</li>
					</div>

					<div class="boxLink">
						<li class="nav-item"><a class="nav-link" href="home">Home</a>
						</li>
						
							<li class="nav-item"><a class="nav-link" href="order">Ricerca & Gestisci
									 </a></li>
							<li class="nav-item"><a class="nav-link" href="prenota">Prenota</a></li>
							<li class="nav-item"><a class="nav-link"
								href="miePrenotazioni">Mie Prenotazioni</a></li>
						
					</div>

					<div class="boxLink">
						
							<li class="nav-item"><p class="username">${sessionScope.utente.username}</p>
							</li>
							<li class="nav-item">
								<form action="logout" method="post">
									<button type="submit" class="logoutBtn">
										<i class="fas fa-sign-out-alt"></i>
									</button>
								</form>
							</li>
						</c:if>
					</div>

				</ul>
			
		</nav>
	</header>
</body>
</html>