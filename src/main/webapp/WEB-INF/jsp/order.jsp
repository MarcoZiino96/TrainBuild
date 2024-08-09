<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Lista Treni</title>
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
    .titleOrder {
        text-align: center;
    }

    .titleOrder h2 {
        margin: 20px;
        padding-top: 40px;
    }

    .formOrder {
        text-align: center;
        margin: 30px;
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

    .action-buttons {
        display: flex;
        align-items: center;
        justify-content: space-between;
        gap: 10px;
    }

    .action-buttons form {
        margin: 0;
    }

    .action-buttons button {
        margin: 0;
        padding: 5px 10px;
        font-size: 14px;
        cursor: pointer;
    }

    .text-center {
        display: flex;
        align-items: center;
        justify-content: center;
    }
    </style>
    <script>
    function confermaEliminazione() {
        return confirm("Sei sicuro di voler eliminare questo treno?");
    }
    </script>
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
                                <form action="eliminaTreno" method="post" onsubmit="return confermaEliminazione()" style="display:inline;">
                                    <input type="hidden" name="trenoId" value="${treno.id}" />
                                    <button type="submit">Elimina</button>
                                </form>
                                <form action="modificaTreno" method="post" style="display:inline;">
                                    <input type="hidden" name="trenoId" value="${treno.id}" />
                                    
                                    <div class="form-group">
                                        <label for="sigla">Sigla</label> 
                                        <input type="text" id="sigla" name="sigla" value="${treno.sigla}" required>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="compagnia">Compagnia</label> 
                                        <select id="compagnia" name="compagnia" required>
                                            <option value="FR" <c:if test="${treno.compagnia == 'FR'}">selected</c:if>>Frecciarossa(FR)</option>
                                            <option value="IT" <c:if test="${treno.compagnia == 'IT'}">selected</c:if>>Italo(IT)</option>
                                            <option value="TN" <c:if test="${treno.compagnia == 'TN'}">selected</c:if>>Trenord(TN)</option>
                                        </select>
                                    </div>
                                    
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-success">Modifica Treno</button>
                                    </div>
                                </form>
                                <form action="duplicaTreno" method="post" style="display:inline;">
                                    <input type="hidden" name="trenoId" value="${treno.id}" />
                                    <button type="submit">Duplica</button>
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
