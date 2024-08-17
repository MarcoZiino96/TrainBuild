<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestione Treni</title>
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

    .suggestion {
        border-color: green;
        background-color: #d4edda;
        color: #155724;
    }

    .action-buttons {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
        gap: 10px;
    }

    .action-buttons form {
        margin: 0;
        flex-grow: 1;
    }

    .action-buttons button {
        width: 100%;
        padding: 6px 12px;
        font-size: 14px;
        cursor: pointer;
        border: 1px solid #ccc;
        border-radius: 4px;
        background-color: #28a745;
        color: white;
        transition: background-color 0.3s ease;
    }

    .action-buttons button.delete {
        background-color: #dc3545;
    }

    .action-buttons button.delete:hover {
        background-color: #c82333;
    }

    .action-buttons button.duplicate {
        background-color: #17a2b8;
    }

    .action-buttons button.duplicate:hover {
        background-color: #117a8b;
    }

    .action-buttons button.modify {
        background-color: #007bff;
    }

    .action-buttons button.modify:hover {
        background-color: #0056b3;
    }

    .action-buttons button.invert {
        background-color: #ffc107;
    }

    .action-buttons button.invert:hover {
        background-color: #e0a800;
    }
    </style>
    <script>
    function confermaEliminazione() {
        return confirm("Sei sicuro di voler eliminare questo treno?");
    }

    function confermaModifica() {
        return confirm("Sei sicuro di voler modificare questo treno?");
    }

    function confermaDuplicazione() {
        return confirm("Sei sicuro di voler duplicare questo treno?");
    }

    function confermaInversione() {
        return confirm("Sei sicuro di voler invertire la sigla di questo treno?");
    }
    </script>
</head>
<body>

    <jsp:include page="header.jsp" />

    <div class="titleOrder"> 
        <h2>Gestisci i tuoi treni</h2>
    </div> 

    <c:if test="${not empty errorMessage}">
        <div class="message error">
            <p>${errorMessage}</p>
            <c:if test="${not empty errorSigla}">
                <p>Sigla Errore: ${errorSigla}</p>
            </c:if>
        </div>
    </c:if>

    <c:if test="${not empty errorSuggerimento}">
        <div class="message suggestion">
            <p>Suggerimento: ${errorSuggerimento}</p>
            <c:if test="${not empty errorSiglaSuggerita}">
                <p>Sigla Suggerita: ${errorSiglaSuggerita}</p>
            </c:if>
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
                <th>Azioni</th>
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
                    <td>
                        <c:if test="${treno.utente.id == utente.id}">
                            <div class="action-buttons">
                                <form action="eliminaTreno" method="post" onsubmit="return confermaEliminazione()">
                                    <input type="hidden" name="trenoId" value="${treno.id}" />
                                    <button type="submit" class="delete">Elimina</button>
                                </form>
                                
                                <form action="modificaTreno" method="post" onsubmit="return confermaModifica()">
                                    <input type="hidden" name="trenoId" value="${treno.id}" />
                                    <div>
                                        <label for="sigla">Sigla</label> 
                                        <input type="text" id="sigla" name="sigla" value="${treno.sigla}" required>
                                    </div>
                                    <div>
                                        <label for="compagnia">Compagnia</label> 
                                        <select id="compagnia" name="compagnia" required>
                                            <option value="FR" <c:if test="${treno.compagnia == 'FR'}">selected</c:if>>Frecciarossa(FR)</option>
                                            <option value="IT" <c:if test="${treno.compagnia == 'IT'}">selected</c:if>>Italo(IT)</option>
                                            <option value="TN" <c:if test="${treno.compagnia == 'TN'}">selected</c:if>>Trenord(TN)</option>
                                        </select>
                                    </div>
                                    <button type="submit" class="modify">Modifica Treno</button>
                                </form>
                                
                                <form action="duplicaTreno" method="post" onsubmit="return confermaDuplicazione()">
                                    <input type="hidden" name="trenoId" value="${treno.id}" />
                                    <button type="submit" class="duplicate">Duplica</button>
                                </form>

                                <form action="invertiTreno" method="post" onsubmit="return confermaInversione()">
                                    <input type="hidden" name="trenoId" value="${treno.id}" />
                                    <button type="submit" class="invert">Inverti</button>
                                </form>
                            </div>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</body>
</html>
