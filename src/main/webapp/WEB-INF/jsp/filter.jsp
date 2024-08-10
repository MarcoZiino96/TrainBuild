<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Filtra i treni:</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/filter.css">




</head>

<body>

    <jsp:include page="header.jsp" />
   
   <div class="filter"> 
    <h2>Applica un filtro alla lista dei treni</h2>
   </div> 
      

    <c:if test="${not empty error}">
        <div style="color: red;">
            ${error}
        </div>
    </c:if>
   
   
   <div class="formFilter">
    <form action="filter" method="get">
        <label for="lunghezzaMin">Lunghezza Min:</label>
        <input type="number" id="lunghezzaMin" name="lunghezzaMin" min="0" step="1" />

        <label for="lunghezzaMax">Lunghezza Max:</label>
        <input type="number" id="lunghezzaMax" name="lunghezzaMax" min="0" step="1" />

        <label for="prezzoMin">Prezzo Min:</label>
        <input type="number" id="prezzoMin" name="prezzoMin" min="0" step="1" />

        <label for="prezzoMax">Prezzo Max:</label>
        <input type="number" id="prezzoMax" name="prezzoMax" min="0" step="1" />
        
        <label for="pesoMin">Peso Min:</label>
        <input type="number" id="pesoMin" name="pesoMin" min="0" step="1" />

        <label for="pesoMax">Peso Max:</label>
        <input type="number" id="pesoMax" name="pesoMax" min="0" step="1" />

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

<img src = "resources/train.png">
    

    
</body>
</html>