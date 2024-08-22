<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>TrainBuild</title>
   
	<link rel="icon" href="${pageContext.request.contextPath}\resources\img\favicon.png" type="image/x-icon">     
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/formlogin.css">
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/formlogin.js"></script> 
     
</head>

<body>

	<header>
		<jsp:include page="header.jsp" />
	</header>

	<div class="boxLogin">
       <h2 id = "welcomeLogin">${message1}</h2>

    
       <form:form modelAttribute="utente" action="formlogin" method="post">
            <label for="username">Username:</label>
            <div id="usernameError" class="message"></div>
            <form:input path="username" onkeyup = "validateUsername()"/>
            <form:errors path="username" cssClass="message" />

<label for="password">Password:</label>
			<div id="passwordError" class="message"></div>
			<div class="password-container">
				<form:input path="password" id="password-field" type="password" onkeyup="validatePassword()" />
				<span class="password-toggle-icon"
					onclick="togglePassword()"> <i class="fa fa-eye"></i>
				</span>
			</div>
			<form:errors path="password" cssClass="message" />
			
			
			<div class="submit">
				<button type="submit">Login</button>
			</div>
               
        </form:form>   

	</div>
</body>

</html>