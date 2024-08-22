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

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/preRegister.css">



</head>
<body>


	<jsp:include page="header.jsp" />
	<div class="boxRegister">
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
			<div id="dataNascitaError" class="message"></div>
			<form:input path="dataNascita" type="date" onkeyup="validateDataNascita()" />
			<form:errors path="dataNascita" cssClass="message" />

			<label for="username">Username:</label>
			<div id="usernameError" class="message"></div>
			<form:input path="username" onkeyup = "validateUsername()"  />
			<form:errors path="username" cssClass="message" />

            <label for="password">Password:</label>
			<div id="passwordError" class="message"></div>
			<div class="password-container">
				<form:input path="password" class="password-field" type="password"
					onkeyup="validatePassword()" />
				<span class="password-toggle-icon"
					onclick="togglePassword()"> <i class="fa fa-eye"></i>
				</span>
			</div>
			<form:errors path="password" cssClass="message" />
			
			
			
			<label for="verificaPassword">Verifica Password:</label>
			<div id="verificaPasswordError" class="message"></div>
			<div class="verifica-password-container">
			<form:input path="verificaPassword" type="password" class="verifica-password-field" onkeyup = "validateVerificaPassword()"/>
			<span class="verifica-password-toggle-icon"
					onclick="toggleVerificaPassword()"> <i class="fa fa-eye"></i>
				</span>
				</div>
			<form:errors path="verificaPassword" cssClass="message" />
			
			

			<div class="submit">
				<button type="submit"> Registrami  </button>
			</div>

		</form:form>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/preRegister.js"></script> 
</body>
</html>