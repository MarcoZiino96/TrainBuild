document.addEventListener('DOMContentLoaded', function () {
	    function validateSigla() {
	        var sigla = document.getElementById("sigla").value;
	        var siglaError = document.getElementById('siglaError');
	        var valid = true;

	        siglaError.textContent = ""; 
	        
	        //inizio controlli
	        var caratteriAmmessi = ['H', 'C', 'R', 'P'];
	        for (var i = 0; i < sigla.length; i++) {
	            if (!caratteriAmmessi.includes(sigla[i].toUpperCase())) {
	                siglaError.textContent = "La sigla può contenere solo i caratteri 'H', 'C', 'R', e 'P'.";
	                valid = false;
	                return valid;
	            }
	        }
	        
	        if (sigla[0].toLowerCase() !== 'h') {
	            siglaError.textContent = "La sigla deve iniziare con una locomotiva 'H'.";
	            valid = false;
	            return valid;
	        }

	        if (sigla.length < 2 || sigla.length > 8) {
	            siglaError.textContent = "La sigla deve avere tra 2 e 8 caratteri.";
	            valid = false;
	        }

	        var countH = (sigla.match(/H/gi) || []).length;
	        if (countH > 2) {
	            siglaError.textContent = "Il treno non può contenere più di due locomotive.";
	            valid = false;
	            return valid; 
	        }

	        var dalSecondoChar = sigla.slice(1).toLowerCase();
	        if (dalSecondoChar.includes('h')) {
	           
	            if (dalSecondoChar.indexOf('h') !== dalSecondoChar.length - 1 || dalSecondoChar.lastIndexOf('h') !== dalSecondoChar.indexOf('h')) {
	                siglaError.textContent = "La seconda locomotiva (H) deve trovarsi alla fine della sigla.";
	                valid = false;
	            }
	        }
	        
	        if (dalSecondoChar.includes('r') || dalSecondoChar.includes('R')) {
	            // Controlla se ci sono più di una 'R' o 'r' nella sigla
	            if (dalSecondoChar.toLowerCase().split('r').length - 1 > 1) {
	                siglaError.textContent = "La sigla può contenere solo un carattere 'R'.";
	                valid = false;
	            }
	        }

	        if (dalSecondoChar.includes('c')) {
	            if (!(dalSecondoChar.startsWith('c') && (dalSecondoChar.endsWith('h') || !dalSecondoChar.includes('h')))) {
	                siglaError.textContent = "'C' è l'unico carattere ammesso (è possibile inserire 'H' in coda)";
	                valid = false;
	            }
	        }

	        return valid;
	    }

	    document.getElementById("sigla").addEventListener("keyup", validateSigla);

	    document.querySelector("form").addEventListener('submit', function (event) {
	        if (!validateSigla()) {
	            event.preventDefault(); 
	        }
	    });
	});