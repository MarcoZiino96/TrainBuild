document.addEventListener('DOMContentLoaded', function() {
		
		function validateNome(){
			var nome = document.getElementById("nome").value;
			var nomeError = document.getElementById("nomeError");
			var nomePattern = /^[A-Za-zàèìòùÀÈÌÒÙ' -]{2,20}$/;
			
			
			if(nome.trim() === "") {
	            nomeError.textContent = "Informazione obbligatoria";
	            return false;
			}else if(!nomePattern.test(nome)){
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
			
			if(cognome.trim() === "") {
	            cognomeError.textContent = "Informazione obbligatoria";
	            return false;
			}else if(!cognomePattern.test(cognome)){
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
			
			if(email.trim() === "") {
	            emailError.textContent = "Informazione obbligatoria";
	            return false;
			}else if(!emailPattern.test(email)){
				emailError.textContent = ("Email non valida");
			} else {
				emailError.textContent = ("");
				return true;
			}	
		}
		
		function validateDataNascita() {
		        var dataNascita = document.getElementById("dataNascita").value;
		        var dataNascitaError = document.getElementById("dataNascitaError");

		        if(dataNascita.trim() === "") {
		            dataNascitaError.textContent = "Informazione obbligatoria";
		            return false;
		        } else {
		            dataNascitaError.textContent = "";
		            return true;
		        }
		    }
		
		 function validateUsername() {
		        var username = document.getElementById("username").value;
		        var usernameError = document.getElementById("usernameError");
		        var usernamePattern = /^(?=.*\d)(?=.*[\W_]).{5,}$/;
				
		        if(username.trim() === "") {
		            usernameError.textContent = "Informazione obbligatoria";
		            return false;
		        }else if(!usernamePattern.test(username)) {
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
				
		        if(password.trim() === "") {
		            passwordError.textContent = "Password obbligatoria";
		            return false;
		        }else if(!passwordPattern.test(password)) {
		            passwordError.textContent = "La password deve contenere almeno 1 lettera maiuscola, 1 lettera minuscola, 1 numero, 1 carattere speciale e deve essere di almeno 8 caratteri.";
		            return false;
		        } else {
		            passwordError.textContent = "";
		            return true;
		        }
		    }
		 
		 
		 
		 
		 
		 
		 
		 function validateVerificaPassword() {
		        var password = document.getElementById("password").value;
		        var verificaPassword = document.getElementById("verificaPassword").value;
		        var verificaPasswordError = document.getElementById("verificaPasswordError");

		        if(verificaPassword.trim() === "") {
		            verificaPasswordError.textContent = "Verifica password obbligatoria";
		            return false;
		        } else if(password !== verificaPassword) {
		            verificaPasswordError.textContent = "Le password non corrispondono";
		            return false;
		        } else {
		            verificaPasswordError.textContent = "";
		            return true;
		        }
		    }
		 
		 function validatePreRegister() {
			 var isNomeValid = validateNome();
			 var isCognomeValid = validateCognome()
			 var isEmailValid = validateEmail();
			 var isDataNascitaValid = validateDataNascita();
		     var isUsernameValid = validateUsername();
		     var isPasswordValid = validatePassword();
		     var isVerificaPasswordValid = validateVerificaPassword();
		     
		     return isNomeValid && isCognomeValid && isEmailValid && isUsernameValid && isPasswordValid;
		    }
		 
		 document.getElementById("nome").addEventListener("keyup", validateNome);
		 document.getElementById("cognome").addEventListener("keyup", validateCognome);
		 document.getElementById("email").addEventListener("keyup", validateEmail);
		 document.getElementById("dataNascita").addEventListener("keyup", validateDataNascita);
		 document.getElementById("username").addEventListener("keyup", validateUsername);
		 document.getElementById("password").addEventListener("keyup", validatePassword);
		 document.getElementById("verificaPassword").addEventListener("keyup", validateVerificaPassword);
		
		 document.querySelector("form").addEventListener('submit', function(event) {
		        if (!validatePreRegister()) {
		            event.preventDefault();
		            
		           
		        }
		        
		        console.log( document.querySelector("form"))
		    });
		});
		
		
		
function togglePassword() {
    var password = document.querySelector(".password-field");
    var icon = document.querySelector(".password-toggle-icon i");

    if (password.type === "password") {
        password.type = "text";
        icon.classList.remove("fa-eye");
        icon.classList.add("fa-eye-slash");
    } else {
        password.type = "password"; 
        icon.classList.remove("fa-eye-slash");
        icon.classList.add("fa-eye");
    }
}


function toggleVerificaPassword() {
    var password = document.querySelector(".verifica-password-field");
    var icon = document.querySelector(".verifica-password-toggle-icon i");

    if (password.type === "password") {
        password.type = "text";
        icon.classList.remove("fa-eye");
        icon.classList.add("fa-eye-slash");
    } else {
        password.type = "password"; 
        icon.classList.remove("fa-eye-slash");
        icon.classList.add("fa-eye");
    }
}
		
	
		
    