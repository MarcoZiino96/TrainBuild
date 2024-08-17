<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista Treni</title>
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f4f9;
        margin: 20px;
        color: #333;
    }

    h2 {
        color: #444;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    th, td {
        border: 1px solid #ddd;
        text-align: left;
        padding: 12px;
    }

    th {
        background-color: #f8f8f8;
        color: #555;
        font-weight: bold;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    .titleOrder {
        text-align: center;
        margin-bottom: 20px;
    }

    .formOrder {
        text-align: center;
        margin: 30px auto;
    }

    .formOrder label {
        font-weight: bold;
        margin-right: 10px;
    }

    .formOrder select, .formOrder button {
        padding: 8px 12px;
        margin-right: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .formOrder button {
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .formOrder button:hover {
        background-color: #0056b3;
    }

    .message {
        text-align: center;
        margin: 20px auto;
        padding: 15px;
        border-radius: 4px;
    }

    .error {
        border-color: red;
        background-color: #f8d7da;
        color: #721c24;
    }

    .success {
        border-color: green;
        background-color: #d4edda;
        color: #155724;
    }

    .text-center {
        text-align: center;
    }

    .text-center a.btn {
        padding: 10px 20px;
        font-size: 16px;
        color: white;
        background-color: #007bff;
        text-decoration: none;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }

    .text-center a.btn:hover {
        background-color: #0056b3;
    }
    </style>
</head>
<body>

    <jsp:include page="header.jsp" />

    <div class="titleOrder"> 
        <h2>Ricerca un treno con l'ordinamento che preferisci</h2>
    </div> 
        
    <form class="formOrder" action="order" method="get">
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
        
        <button type="submit">Cerca</button>
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

    <c:if test="${not empty utente}">
        <div class="text-center">
            <a href="gestioneTreni" class="btn btn-primary">Gestisci i Treni</a>
        </div>
    </c:if>
    
</body>
</html>
