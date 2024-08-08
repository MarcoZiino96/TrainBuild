<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Filtra i treni:</title>
    <style>
    @charset "UTF-8";

body {
    font-family: Arial, sans-serif;
    margin: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

th {
    background-color: #f2f2f2;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

tr:hover {
    background-color: #f1f1f1;
}
.titleOrder{
text-align: center;
}
.titleOrder h2{
margin: 20px;
padding-top: 40px;
}

.formOrder{
text-align: center;
margin: 30px;
}
    </style>
</head>

<body>

    <jsp:include page="header.jsp" />
   
   <div class="titleOrder"> 
    <h2>Applica un filtro alla lista dei treni</h2>
   </div> 
   
   
   <div class="formOrder">
    <form action="filterTreni" method="get">
        <label for="lunghezzaMin">Lunghezza Min:</label>
        <input type="number" id="lunghezzaMin" name="lunghezzaMin" min="0" />

        <label for="lunghezzaMax">Lunghezza Max:</label>
        <input type="number" id="lunghezzaMax" name="lunghezzaMax" min="0" />

        <label for="prezzoMin">Prezzo Min:</label>
        <input type="number" id="prezzoMin" name="prezzoMin" min="0" step="0.01" />

        <label for="prezzoMax">Prezzo Max:</label>
        <input type="number" id="prezzoMax" name="prezzoMax" min="0" step="0.01" />

        <label for="siglaContains">Sigla Contiene:</label>
        <input type="text" id="siglaContains" name="siglaContains" />

        <label for="utente">Utente:</label>
        <input type="text" id="utente" name="utente" />

        <button type="submit">Applica Filtro</button>
    </form>
</div>
        
  
  <table>
    <thead>
        <tr>
            <th>Foto</th>
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
                <td><img src="${treno.foto}" alt="Foto del treno" /></td>
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