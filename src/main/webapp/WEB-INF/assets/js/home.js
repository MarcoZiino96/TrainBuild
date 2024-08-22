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
            if (dalSecondoChar.toLowerCase().split('r').length - 1 > 1) {
                siglaError.textContent = "La sigla può contenere solo un carattere 'R'.";
                valid = false;
            }
        }
        
        
		//controlli cargo
        if (dalSecondoChar.includes('c')) {
            var cIndex = dalSecondoChar.indexOf('c');
            var primaDiC = dalSecondoChar.slice(0, cIndex);
            var dopoC = dalSecondoChar.slice(cIndex + 1);
            
            var senzaCprima = primaDiC.split('').some(char => char.toLowerCase() !== 'c');

            if (primaDiC.length > 0 && senzaCprima) {
                siglaError.textContent = "'C' è l'unico carattere ammesso prima di una 'C' (è possibile inserire 'H' in coda)";
                valid = false;
                return valid;
            }

            var senzaCdopo = dopoC.split('').some(char => char.toLowerCase() !== 'c' && char.toLowerCase() !== 'h');

            if (dopoC.length > 0 && senzaCdopo) {
                siglaError.textContent = "'C' è l'unico carattere ammesso dopo una 'C' (è possibile inserire 'H' in coda)";
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