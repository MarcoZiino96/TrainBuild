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
	
	<!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css">-->
	
	

	
<style>

body {
    margin: 0;
    font-family: Verdana, Arial, Helvetica, sans-serif; 
}


.navbar {
    background-color: #2f1847;
    padding: 10px 20px;
    height: 100px;
    display: flex;
    align-items: center;
    font-family: Verdana, Arial, Helvetica, sans-serif; 
    font-size: 18px;
    box-shadow: 0 0 15px 8px rgba(255, 255, 255, 0.2);
}

.container {
    max-width: 1200px; 
    margin: 0 auto;
    display: flex;
    justify-content: center; 
}

.navbar-nav {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    align-items: center;
    font-family: Verdana, Arial, Helvetica, sans-serif;
}

.nav-item {
    margin: 0 20px; 
    font-family: Verdana, Arial, Helvetica, sans-serif;
}

.nav-link {
    text-decoration: none;
    color: #fff; 
    font-weight: bold;
    font-size: inherit; 
    font-family: Verdana, Arial, Helvetica, sans-serif;
}

.nav-link:hover {
    color: #cda434; 
}

.user-logout-container {
    display: flex;
    align-items: center;
}

.username {
    color: #fff;
    margin-right: 10px; 
    margin-left: 20px;
}

.logoutBtn {
    background-color: #cda434; 
    border: none;
    color: #2f1847; 
    padding: 5px 10px;
    cursor: pointer;
    border-radius: 4px;
    font-size: inherit; 
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
                    <div class="user-logout-container">
                        <span class="username">${sessionScope.utente.username}</span>
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