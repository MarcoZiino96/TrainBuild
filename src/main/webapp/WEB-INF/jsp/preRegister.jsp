<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrazione Utente</title>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/preRegister.css">
</head>
<body>
   <jsp:include page="header.jsp" />
       
  <div class="boxRegister">
        <h2 id="userRegister">Registrazione Utente</h2>
      
        <form:form modelAttribute="utente" action="postRegister" method="post">

            <label for="nome">Nome:</label>
            <form:input path="nome" />
            <form:errors path="nome" cssClass="message" />

            <label for="cognome">Cognome:</label>
            <form:input path="cognome" />
            <form:errors path="cognome" cssClass="message" />

            <label for="email">Email:</label>
            <form:input path="email" />
            <form:errors path="email" cssClass="message" />

            <label for="dataNascita">Data di Nascita:</label>
            <form:input path="dataNascita" type = "date"/>
            <form:errors path="dataNascita" cssClass="message" />

            <label for="username">Username:</label>
            <form:input path="username" />
            <form:errors path="username" cssClass="message" />

            <label for="password">Password:</label>
            <form:input path="password" />
            <form:errors path="password" cssClass="message" />

            <div class="submit">
            <button type="submit" value="Registrati">Registrami</button>
            </div>
            
        </form:form> 
        
    </div>
</body>
</html>