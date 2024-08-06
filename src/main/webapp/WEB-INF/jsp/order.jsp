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

        .star-rating {
            direction: rtl;
            display: inline-block;
        }

        .star-rating input[type="radio"] {
            display: none;
        }

        .star-rating label {
            color: #ddd;
            font-size: 20px;
            padding: 0;
            cursor: pointer;
        }

        .star-rating input[type="radio"]:checked ~ label {
            color: #f5b301;
        }

        .star-rating label:hover,
        .star-rating label:hover ~ label {
            color: #f5b301;
        }
    </style>
</head>

<body>

    <jsp:include page="header.jsp" />
   
    <div class="titleOrder"> 
        <h2>Ricerca un treno con l'ordinamento che preferisci</h2>
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
        
        <button type="submit">Cerca</button>
    </form>
    
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
                <th>Vota</th>
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
                        <form action="votaTreno" method="post">
                            <input type="hidden" name="trenoId" value="${treno.id}" />
                            <input type="hidden" name="utenteId" value="${sessionScope.utente.id}" />
                            <div class="star-rating">
                                <input type="radio" name="voto" value="5" id="5-${treno.id}"><label for="5-${treno.id}">☆</label>
                                <input type="radio" name="voto" value="4" id="4-${treno.id}"><label for="4-${treno.id}">☆</label>
                                <input type="radio" name="voto" value="3" id="3-${treno.id}"><label for="3-${treno.id}">☆</label>
                                <input type="radio" name="voto" value="2" id="2-${treno.id}"><label for="2-${treno.id}">☆</label>
                                <input type="radio" name="voto" value="1" id="1-${treno.id}"><label for="1-${treno.id}">☆</label>
                            </div>
                            <button type="submit">Vota</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</body>
</html>
