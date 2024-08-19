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

    .hidden {
        display: none;
    }
    </style>
    <script>
        function toggleOrder() {
            var form = document.getElementById("order");
            form.classList.toggle("hidden");
        }
        function toggleFilter() {
            var form = document.getElementById("filter");
            form.classList.toggle("hidden");
        }
    </script>
</head>
<body>

    <jsp:include page="header.jsp" />

    <div class="containerOrder">

        <div class="containerRicerca">

            <div class="boxOrder">

                <div class="titleOrder">
                    <h2>Ricerca un treno con l'ordinamento che preferisci</h2>
                    <button class="submitBtn" onClick="toggleOrder()">Ordina</button>
                </div>

                <form id="order" class="formOrder hidden" action="order" method="get">
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
            </div>

            <div class="boxFilter">
                <div class="titleFilter">
                    <h2>Applica un filtro alla lista dei treni</h2>
                    <button class="submitBtn" onClick="toggleFilter()">Filtra</button>
                </div>

                <c:if test="${not empty error}">
                    <div style="color: red;">${error}</div>
                </c:if>

                <form id="filter" class="formFilter hidden" action="filter" method="get">
                    <div>
                        <h5>LUNGHEZZA</h5>
                        <div>
                            <span> Min:</span> <input name="lunghezzaMin" class="uniform-input" type="number" min="0" step="1" />
                        </div>
                        <div>
                            <span> Max:</span> <input name="lunghezzaMax" class="uniform-input" type="number" min="0" step="1" />
                        </div>
                    </div>

                    <div>
                        <h5>PREZZO</h5>
                        <div>
                            <span> Min:</span> <input name="prezzoMin" class="uniform-input" type="number" min="0" step="1" />
                        </div>
                        <div>
                            <span> Max:</span> <input name="prezzoMax" class="uniform-input" type="number" min="0" step="1" />
                        </div>
                    </div>

                    <div>
                        <h5>PESO</h5>
                        <div>
                            <span> Min:</span> <input name="pesoMin" class="uniform-input" type="number" min="0" step="1" />
                        </div>
                        <div>
                            <span> Max:</span> <input name="pesoMax" class="uniform-input" type="number" min="0" step="1" />
                        </div>
                    </div>

                    <div>
                        <h5>SIGLA E UTENTE</h5>
                        <span>Sigla:</span> <input name="siglaContains" class="uniform-input" type="text" />
                    </div>

                    <div>
                        <span>Utente:</span> <input name="utente" class="uniform-input" type="text" />
                    </div>

                    <div class="button-container">
                        <button class="submitBtn" type="submit">Applica Filtro</button>
                    </div>
                </form>
            </div>

        </div>

        <div class="boxTable">
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
                        <th>Azioni</th>
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
                                <form action="selectDetails" method="post">
                                    <input type="hidden" name="id" value="${treno.id}" />
                                    <button class="submitBtn" type="submit">Dettagli</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
