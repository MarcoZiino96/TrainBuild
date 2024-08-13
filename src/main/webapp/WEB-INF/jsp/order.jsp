<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Lista Treni</title>
    
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/order.css">
   <!--<style>
    @charset "UTF-8";

body {
    font-family: Arial, sans-serif;
    margin: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

th, td {
	border: 1px solid #666666; 
	text-align: left;
	padding: 12px;
	margin-top: 20px;
}

th {
    background-color: #E6E6FA;
	color: #333333;
	text-transform: uppercase; 
    font-weight: bold;
}

tr:nth-child(even) {
    background-color: #E6E6FA;
}

tr:nth-child(odd) {
    background-color: #F8F8FF; 
}

tr:hover {
    background-color: #f1f1f1;
	background-color: rgba(230, 230, 250, 0.2);
}
.titleOrder{
text-align: center;
}
.titleOrder h2{
margin: 20px;
padding-top: 40px;
}

.formOrder{
	display: flex;
	justify-content: center; 
	gap: 50px; 
	flex-wrap: wrap;
	margin: 30px;
}

.button {
	padding: 10px 20px; 
	background-color: #4CAF50;
    color: white;
    border:none;
    border-radius: 4px;
    </style> -->
</head>

<body>

    <jsp:include page="header.jsp" />
   
   <div class="titleOrder"> 
    <h2>Ordina i treni secondo l'ordinamento che preferisci</h2>
   </div> 
        
       <form class="formOrder">
        <label for="ordinamento">Ordina per:</label>
    	<select id="ordinamento" name="ordinamento">
        <option value="compagnia">Compagnia</option>
        <option value="sigla">Sigla</option>
        <option value="lunghezza">Lunghezza</option>
        <option value="peso">Peso</option>
        <option value="prezzo">Prezzo</option>
    </select>
    
    <label for="direction">Direzione:</label>
    <select id="direction" name="direction">
        <option value="ASC">Crescente</option>
        <option value="DESC">Decrescente</option>
    </select>
    
        <button class = "button" type="submit">Cerca</button>
    </form>
    
    
  <table>
    <thead>
        <tr>
            <th>Compagnia</th>
            <th>Sigla</th>
            <th>Lunghezza</th>
            <th>Peso</th>
            <th>Prezzo</th>
            <th>Utente</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="treno" items="${treni}">
            <tr>
                <td>${treno.compagnia}</td>
                <td>${treno.sigla}</td>
                <td>${treno.lunghezza}</td>
                <td>${treno.peso}</td>
                <td>${treno.prezzo}</td>
                <td>${treno.utente.username}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
     
</body>
</html>