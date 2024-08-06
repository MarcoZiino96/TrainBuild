<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 15px 20px;
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
        h2, .submit{
        text-align: center;
        font-size: 1.5rem;
        }
        .message{
        color:red;
        font-size: 0.8rem;
        }
       
    </style>
</head>

    <body> 

       <header>
          <jsp:include page="header.jsp" />
       </header>

       <h2>${message1}</h2>

    
       <form:form modelAttribute="utente" action="formlogin" method="post">
            <label for="username">Username:</label>
            <form:input path="username"/>
            <form:errors path="username" cssClass="message" />

            <label for="password">Password:</label>
            <form:input path="password" type="password" />
            <form:errors path="password" cssClass="message" />
            <div class="submit">
            <input type="submit"  value="Login">
            </div>
               
        </form:form>   
    


</body>  
</html>