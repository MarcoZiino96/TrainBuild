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
 <!--<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
  <link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css"
	rel="stylesheet"> -->
	
	<!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css">-->
	
<style>



.navbar {
    background-color: #2f1847;
    color: #fafafa;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-size: 18px;
    padding: 10px;
    box-shadow: 0 2px 20px #fafafa;
    height: 100px;
}

.container {
    max-width: 1200px;
    height: 80px;
    margin: 0 auto;
    display: flex;
    align-items: center;
}

.navbar-nav {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    display: flex;
    align-items: center; 
}

.nav-item {
    margin-right: 40px; 

.nav-item:last-child {
    margin-right: 0; 
}

.username {
    margin-right: -15px; 
    margin-left: 50px;
    font-size: 14px;
    color: #cda434;
}

.nav-link {
    color: white;
    text-decoration: none;
    font-weight: 500;
    transition: color 0.3s ease;
}

.nav-link:hover, .nav-link:focus {
    color: #cda434;
}

.logout-container {
    display: flex;
    align-items: center; 
}

.logoutBtn {
    padding: 10px 10px;
    background-color: #fafafa;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    color: #2f1847;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 30px;
    margin-bottom:10px;
}

.logoutBtn:hover {
    background-color: #e0c680;
}
</style> 
</head>
<body>
	<header>
    <nav class="navbar">
        <div class="container">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Chi siamo</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Contatti</a></li>
                <c:if test="${not empty sessionScope.utente}">
                    <li class="nav-item"><a class="nav-link" href="order">Ordinamento</a></li>
                    <li class="nav-item"><a class="nav-link" href="filter">Ricerca</a></li>
                    <li class="nav-item">
                        <span class="username">${sessionScope.utente.username}</span> 
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