<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<title>TrainBuild</title>
<link rel="icon" href="${pageContext.request.contextPath}\resources\img\favicon.png" type="image/x-icon">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/formlogin.css">


=======
    <title>Login Form</title>
        
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/formlogin.css">
     <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/formlogin.js"></script> 
     
>>>>>>> 90f2b567bec0ce6754d026a4a8a716a3450232af
</head>

<body>

	<header>
		<jsp:include page="header.jsp" />
	</header>

<<<<<<< HEAD
	<div class="boxLogin">
		<h2 id="welcomeLogin">${message1}</h2>

=======
       <h2 id = "welcomeLogin">${message1}</h2>

    
       <form:form modelAttribute="utente" action="formlogin" method="post">
            <label for="username">Username:</label>
            <div id="usernameError" class="message"></div>
            <form:input path="username" onkeyup = "validateUsername()"/>
            <form:errors path="username" cssClass="message" />

            <label for="password">Password:</label>
            <div id="passwordError" class="message"></div>
            <form:input path="password" type="password" onkeyup = "validatePassword()" />
            <form:errors path="password" cssClass="message" />
            <div class="submit">
            <input type="submit"  value="Login">
            </div>
               
        </form:form>   
        
>>>>>>> 90f2b567bec0ce6754d026a4a8a716a3450232af

		<form:form modelAttribute="utente" action="formlogin" method="post">
			<label for="username">Username:</label>
			<form:input path="username" />
			<form:errors path="username" cssClass="message" />

			<label for="password">Password:</label>
			<form:input path="password" type="password" />
			<form:errors path="password" cssClass="message" />
			<div class="submit">
				<button type="submit" value="Login">Login</button>
			</div>

		</form:form>


	</div>
</body>
</html>