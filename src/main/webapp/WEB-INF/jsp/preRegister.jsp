<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrazione Utente</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/preRegister.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/preRegister.js"></script> 


</head>
<body>


	<jsp:include page="header.jsp" />

	<div class="container">
		<h2 id="userRegister">Registrazione Utente</h2>

		<form:form modelAttribute="utente" action="postRegister" method="post">

			<label for="nome">Nome:</label>
			<div id="nomeError" class="message"></div>
			<form:input path="nome" onkeyup = "validateNome()"/>
			<form:errors path="nome" cssClass="message" />

			<label for="cognome">Cognome:</label>
			<div id="cognomeError" class="message"></div>
			<form:input path="cognome"  onkeyup = "validateCognome()"/>
			<form:errors path="cognome" cssClass="message" />

			<label for="email">Email:</label>
			<div id="emailError" class="message"></div>
			<form:input path="email" onkeyup = "validateEmail()"/>
			<form:errors path="email" cssClass="message" />

			<label for="dataNascita">Data di Nascita:</label>
			<form:input path="dataNascita" type="date" />
			<form:errors path="dataNascita" cssClass="message" />

			<label for="username">Username:</label>
			<div id="usernameError" class="message"></div>
			<form:input path="username" onkeyup = "validateUsername()"  />
			<form:errors path="username" cssClass="message" />

			<label for="password">Password:</label>
			<div id="passwordError" class="message"></div>
			<form:input path="password" onkeyup = "validatePassword()"/>
			<form:errors path="password" cssClass="message" />

			<div class="submit">
				<input type="submit" value="Registrati" />
			</div>

		</form:form>
	</div>

	
</body>
</html>