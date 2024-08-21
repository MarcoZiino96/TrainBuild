<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TrainBuild</title>
<link rel="icon"
	href="${pageContext.request.contextPath}\resources\img\favicon.png"
	type="image/x-icon">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/preRegister.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/preRegister.js"></script> 


</head>
<body>


	<jsp:include page="header.jsp" />

	<div class="boxRegister">
		<h2 id="userRegister">Registrazione Utente</h2>

		<form:form modelAttribute="utente" action="postRegister" method="post">

			<label for="nome">Nome:</label>
			<div id="nomeError" class="message"></div>
			<form:input path="nome" onkeyup = "validateNome()" />
			<form:errors path="nome" cssClass="message" />

			<label for="cognome">Cognome:</label>
			<div id="cognomeError" class="message"></div>
			<form:input path="cognome" onkeyup = "validateCognome()" />
			<form:errors path="cognome" cssClass="message" />

			<label for="email">Email:</label>
			<div id="emailError" class="message"></div>
			<form:input path="email" onkeyup = "validateEmail()" />
			<form:errors path="email" cssClass="message" />

			<label for="dataNascita">Data di Nascita:</label>
			<form:input path="dataNascita" type="date" />
			<form:errors path="dataNascita" cssClass="message" />

			<label for="username">Username:</label>
			<form:input path="username" />
			<form:input path="username" onkeyup = "validateUsername()"/>
			<form:errors path="username" cssClass="message" />

			<label for="password">Password:</label>
			<div id="passwordError" class="message"></div>
			<form:input path="password" onkeyup = "validatePassword()" />
			<form:errors path="password" cssClass="message" />

			<div class="submit">
				<button type="submit" value="Registrati">Registrami</button>
			</div>

		</form:form>

	</div>
</body>
</html>