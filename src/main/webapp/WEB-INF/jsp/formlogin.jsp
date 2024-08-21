<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>TrainBuild</title>
<link rel="icon"
	href="${pageContext.request.contextPath}\resources\img\favicon.png"
	type="image/x-icon">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/formlogin.css">



<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/formlogin.js">
	</script>
</head>

<body>

	<header>
		<jsp:include page="header.jsp" />
	</header>

	<div class="boxLogin">
		<h2 id="welcomeLogin">${message1}</h2>

		<form:form modelAttribute="utente" action="formlogin" method="post">
			<label for="username">Username:</label>
			<div id="usernameError" class="message"></div>
			<form:input path="username" onkeyup="validateUsername()" />
			<form:errors path="username" cssClass="message" />

			<label for="password">Password:</label>
			<div id="passwordError" class="message"></div>
			<form:input path="password" type="password"
				onkeyup="validatePassword()" />
			<form:errors path="password" cssClass="message" />
			<div class="submit">
				<input type="submit" value="Login">
			</div>

		</form:form>

		

	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>