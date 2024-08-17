<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Form</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/formlogin.css">


</head>

<body>

	<header>
		<jsp:include page="header.jsp" />
	</header>

	<div class="boxLogin">
		<h2 id="welcomeLogin">${message1}</h2>


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