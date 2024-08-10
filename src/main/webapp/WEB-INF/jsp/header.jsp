<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nome sito</title>
 <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css"
	rel="stylesheet"> 
<style>
:root {
	--primary-color: #3498db;
	--secondary-color: #2c3e50;
	--background-color: #ecf0f1;
	--text-color: #34495e;
	--hover-color: #2980b9;
	--accent-color: #e74c3c;
}

body {
	background-color: var(--background-color);
	color: var(--text-color);
}

.navbar {
	background-color: white;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.navbar-brand img {
	height: 40px;
}

.nav-link {
	color: var(--secondary-color);
	font-weight: 500;
	transition: color 0.3s ease;
}

.nav-link:hover, .nav-link:focus {
	color: var(--primary-color);
}

.navbar-toggler {
	border-color: var(--primary-color);
}

.search-form {
	width: 100%;
	max-width: 300px;
}

.search-form .form-control {
	border: 2px solid var(--primary-color);
	border-right: none;
	border-radius: 20px 0 0 20px;
}

.search-form .btn {
	background-color: var(--primary-color);
	color: white;
	border: 2px solid var(--primary-color);
	border-radius: 0 20px 20px 0;
	transition: background-color 0.3s ease;
}

.search-form .btn:hover {
	background-color: var(--hover-color);
}

.user-actions .btn {
	color: var(--text-color);
	transition: color 0.3s ease;
}

.user-actions .btn:hover {
	color: var(--primary-color);
}

.btn-primary {
	background-color: var(--accent-color);
	border-color: var(--accent-color);
	transition: background-color 0.3s ease;
}

.btn-primary:hover {
	background-color: #c0392b;
	border-color: #c0392b;
}

span {
	margin-right: 0.2rem;
	margin-bottom: 0.2rem;
	font-size: 0.8rem;
	font-weight: bold;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg">

			<div class="container">
				<div class="collapse navbar-collapse" id="navbarContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="home">Home</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Chi
								siamo</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Contatti</a>
						</li>
						<c:if test="${not empty sessionScope.utente}">

							<li class="nav-item"><a href="order" class="nav-link">Ricerca
									Ordinamento </a></li>
							<li class="nav-item">
							    <span>
							    ${sessionScope.utente.nome}
							    </span> 
								<span>
							    ${sessionScope.utente.cognome}
							    </span> 
							 </li>
							<form:form action="logout" method="post">
								<input type="submit" value="Logout" class="btn btn-primary" />
							</form:form>
						</c:if>

						<c:if test="${empty sessionScope.utente}">
							<a href="formlogin" class="nav-link">Login</a>
							<a href="preRegister" class="nav-link">Registrati</a>
						</c:if>
					</ul>
					<div class="user-actions"></div>
				</div>
			</div>
		</nav>
	</header>
</body>
</html>