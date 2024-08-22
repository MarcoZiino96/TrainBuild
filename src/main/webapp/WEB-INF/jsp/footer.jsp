<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.idm.entity.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TrenoProgetto</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/footer.css">
</head>
<body>

    <%
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null) {
    %>

    <div class="footer">
        <div class="footer-content">
            <div class="footer-section about">
                <h2>Chi Siamo</h2>
                <p>
                    TrainBuild è l'applicazione web leader nella gestione e personalizzazione 
                    dei treni. Offriamo agli utenti la possibilità di creare, salvare e condividere 
                    le proprie composizioni ferroviarie uniche.
                </p>
            </div>

            <div class="footer-section links">
                <h2>Link Utili</h2>
                <ul>
                    <li><a href="home">Home</a></li>
                    <li><a href="order">Treni</a></li>
                    <li><a href="miePrenotazioni">Le Mie Prenotazioni</a></li>
                    <li><a href="prenota">Prenota Treno</a></li>
                    <li><a href="logout">Logout</a></li>
                </ul>
            </div>

            <div class="footer-section contact">
                <h2>Contatti</h2>
                <p><strong>Indirizzo:</strong> Via Stazione Centrale 123, Milano, Italia</p>
                <p><strong>Telefono:</strong> +39 02 12345678</p>
                <p><strong>Email:</strong> support@trainbuild.it</p>
                <div class="socials">
                    <a href="#"><i class="bi bi-facebook"></i></a>
                    <a href="#"><i class="bi bi-twitter"></i></a>
                    <a href="#"><i class="bi bi-instagram"></i></a>
                    <a href="#"><i class="bi bi-linkedin"></i></a>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            &copy; 2024 TrainBuild | Marco, Stefania, Lorenzo
        </div>
    </div>

    <%
        } else {
    %>

    <div class="footer">
        <div class="footer-content">
            <div class="footer-section about">
                <h2>Chi Siamo</h2>
                <p>
                    TrainBuild è l'applicazione web leader nella gestione e personalizzazione 
                    dei treni. Offriamo agli utenti la possibilità di creare, salvare e condividere 
                    le proprie composizioni ferroviarie uniche.
                </p>
            </div>

            <div class="footer-section links">
                <h2>Link Utili</h2>
                <ul>
                    <li><a href="home">Home</a></li>
                    <li><a href="formlogin">Login</a></li>
                    <li><a href="preRegister">Registrati</a></li>
                    <li><a href="order">Treni</a></li>
                </ul>
            </div>

            <div class="footer-section contact">
                <h2>Contatti</h2>
                <p><strong>Indirizzo:</strong> Via Stazione Centrale 123, Milano, Italia</p>
                <p><strong>Telefono:</strong> +39 02 12345678</p>
                <p><strong>Email:</strong> support@trainbuild.it</p>
                <div class="socials">
                    <a href="#"><i class="bi bi-facebook"></i></a>
                    <a href="#"><i class="bi bi-twitter"></i></a>
                    <a href="#"><i class="bi bi-instagram"></i></a>
                    <a href="#"><i class="bi bi-linkedin"></i></a>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            &copy; 2024 TrainBuild | Progettato da Marco, Stefania, Lorenzo
        </div>
    </div>

    <%
        }
    %>

</body>
</html>
