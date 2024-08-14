<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrazione Utente</title>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/preRegister.css">
   <!-- 
   <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
             } 
            
       #userRegister {
        text-align: center;
        font-size: 2.5rem;
        margin-top: 40px;
        margin-bottom: 40px;
        }   
         
        form {
            max-width: 500px;
            margin: 0 auto;
            margin-bottom: 40px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], input[type="email"], input[type="password"], input[type="date"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .container {
            width: 90%;
            margin: auto;
        }
        .submit{
        text-align: center;
        font-size: 1.5rem;
        }
        .message{
        color:red;
        font-size: 0.8rem;
        }
       
    </style> -->
    
</head>
<body>

        
         <jsp:include page="header.jsp" />
       
  <div class="container">
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
            <input type="submit" value="Registrati" />
            </div>
            
        </form:form> 
        
    </div>
</body>
</html>