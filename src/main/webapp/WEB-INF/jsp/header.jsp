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
<style>
.body{
 font-family: Verdana, Arial, Helvetica, sans-serif;
}
.navbar {
    background-color: #2f1847;
    color: #fafafa;
    font-size: 18px;
    padding: 10px;
    box-shadow: 0 0 15px 8px rgba(205, 164, 52, 0.2);
    height: 100px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
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
                <li class="nav-item"><a class="nav-link" href="prenota">Prenota</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Mie Prenotazioni</a></li>
                <c:if test="${not empty sessionScope.utente}">
                    <li class="nav-item"><a class="nav-link" href="order">Ricerca Treno</a></li>
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