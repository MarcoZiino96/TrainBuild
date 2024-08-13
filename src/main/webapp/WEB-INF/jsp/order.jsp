<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	background-color: rgba(230, 230, 250, 0.2);
}

.message {
	text-align: center;
	margin: 20px;
	padding: 10px;
	border: 1px solid #ccc;
	background-color: #f2f2f2;
}

.error {
	border-color: red;
	color: red;
}

.success {
	border-color: green;
	color: green;
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
   
   <c:if test="${not empty successSave}">
   	<div style="color: green;">${successSave}</div>
   </c:if>

   <c:if test="${not empty successModifica}">
   	<div style="color: green;">${successModifica}</div>
   </c:if>
        
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
    
	<c:if test="${not empty errorMessage}">
			<div class="message error">
				<p>${errorMessage}</p>
				<c:if test="${not empty errorSigla}">
					<p>Sigla: ${errorSigla}</p>
				</c:if>
				<c:if test="${not empty errorSuggerimento}">
					<p>Suggerimento: ${errorSuggerimento}</p>
				</c:if>
				<c:if test="${not empty errorSiglaSuggerita}">
					<p>Sigla Suggerita: ${errorSiglaSuggerita}</p>
				</c:if>
			</div>
		</c:if>
		<c:if test="${not empty successMessage}">
			<div class="message success">
				<p>${successMessage}</p>
			</div>
		</c:if>

    
  <table>
    <thead>
        <tr>
            <th>Compagnia</th>
            <th>Sigla</th>
            <th>Lunghezza</th>
            <th>Peso</th>
            <th>Prezzo</th>
            <th>Utente</th>
			<th>Voto</th>
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
				<td>${treno.mediaVoti}</td>
				<td>
					<!-- Usa un form per inviare una richiesta POST -->
											<form action="selectDetails" method="post">
												<input type="hidden" name="id" value="${treno.id}" />
												<button type="submit">Dettagli</button>
											</form>
            </tr>
        </c:forEach>
    </tbody>
</table>
     
</body>
</html>
