document.addEventListener('DOMContentLoaded', function() {
	
	function validateNome(){
		var nome = document.getElementById("nome").value;
		var nomeError = document.getElementById("nomeError");
		var nomePattern = /^[A-Za-zàèìòùÀÈÌÒÙ' -]{2,20}$/;
		
		if(!nomePattern.test(nome)){
			nomeError.textContent = ("Il nome deve avere tra 2 e 20 caratteri");
		}else {
			nomeError.textContent = ("");
			return true;
		}
	}
	
	function validateCognome(){
		var cognome = document.getElementById("cognome").value;
		var cognomeError = document.getElementById("cognomeError");
		var cognomePattern = /^[A-Za-zàèìòùÀÈÌÒÙ' -]{2,20}$/;
		
		if(!cognomePattern.test(cognome)){
			cognomeError.textContent = ("Il cognome deve avere tra 2 e 20 caratteri");
		} else {
			cognomeError.textContent = ("");
			return true;
		}	
	}
	
	function validateEmail(){
		var email = document.getElementById("email").value;
		var emailError = document.getElementById("emailError");
		var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		
		if(!emailPattern.test(email)){
			emailError.textContent = ("Email non valida");
		} else {
			emailError.textContent = ("");
			return true;
		}	
	}
	
	 function validateUsername() {
	        var username = document.getElementById("username").value;
	        var usernameError = document.getElementById("usernameError");
	        var usernamePattern = /^(?=.*\d)(?=.*[\W_]).{5,}$/;

	        if (!usernamePattern.test(username)) {
	            usernameError.textContent = "L'username deve contenere almeno 1 numero, 1 carattere speciale e deve essere di almeno 5 caratteri.";
	            return false;
	        } else {
	            usernameError.textContent = "";
	            return true;
	        }
	    }
	 
	 function validatePassword() {
	        var password = document.getElementById("password").value;
	        var passwordError = document.getElementById("passwordError");
	        var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/;

	        if (!passwordPattern.test(password)) {
	            passwordError.textContent = "La password deve contenere almeno 1 lettera maiuscola, 1 lettera minuscola, 1 numero, 1 carattere speciale e deve essere di almeno 8 caratteri.";
	            return false;
	        } else {
	            passwordError.textContent = "";
	            return true;
	        }
	    }
	 
	 function validatePreRegister() {
		 var isNomeValid = validateNome();
		 var isCognomeValid = validateCognome()
		 var isEmailValid = validateEmail();
	     var isUsernameValid = validateUsername();
	     var isPasswordValid = validatePassword();
	     
	     
	     return isNomeValid && isCognomeValid && isEmailValid && isUsernameValid && isPasswordValid;
	    }
	 
	 document.getElementById("nome").addEventListener("keyup", validateNome);
	 document.getElementById("cognome").addEventListener("keyup", validateCognome);
	 document.getElementById("email").addEventListener("keyup", validateEmail);
	 document.getElementById("username").addEventListener("keyup", validateUsername);
	 document.getElementById("password").addEventListener("keyup", validatePassword);
	
	 document.querySelector("form").addEventListener('submit', function(event) {
	        if (!validatePreRegister()) {
	            event.preventDefault();
	        }
	    });
	});
    