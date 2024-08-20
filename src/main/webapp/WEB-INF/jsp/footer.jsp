<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.idm.entity.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TrenoProgetto</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    .footer {
        background-color: #1c1c1c; 
        color: white;
        padding: 40px 20px;
        text-align: center;
    }
    .footer .footer-content {
        max-width: 1200px;
        margin: auto;
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
    }
    .footer .footer-section {
        flex: 1;
        padding: 20px;
        min-width: 250px;
    }
    .footer .footer-section h2 {
        margin-bottom: 15px;
        font-size: 18px;
        color: #8e44ad; 
    }
    .footer .footer-section ul,
    .footer .footer-section li {
        font-size: 14px;
        line-height: 1.6;
        list-style-type: none;
        padding: 0;
        margin: 0;
    }
    .footer .footer-section a {
        color: #8e44ad; 
        text-decoration: none;
    }
    .footer .footer-section a:hover {
        text-decoration: underline;
    }
    .footer .socials a {
        margin: 0 10px;
        text-decoration: none;
        color: #8e44ad;
        font-size: 20px;
    }
    .footer .socials a:hover {
        color: #9b59b6;
    }
    .footer-bottom {
        background-color: #111; 
        color: white;
        padding: 10px 0;
        text-align: center;
        font-size: 14px;
    }
    @media (max-width: 768px) {
        .footer .footer-content {
            flex-direction: column;
        }
        .footer .footer-section {
            padding: 10px;
            margin-bottom: 20px;
        }
    }
</style>
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
                <p><strong>Email:</strong> support@trenoprogetto.it</p>
                <div class="socials">
                    <a href="#"><i class="bi bi-facebook"></i></a>
                    <a href="#"><i class="bi bi-twitter"></i></a>
                    <a href="#"><i class="bi bi-instagram"></i></a>
                    <a href="#"><i class="bi bi-linkedin"></i></a>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            &copy; 2024 TrenoProgetto | Marco,Stefania,Lorenzo
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
            &copy; 2024 TrainBuild | Progettato da Marco,Stefania,Lorenzo
        </div>
    </div>

    <%
        }
    %>

</body>
</html>
