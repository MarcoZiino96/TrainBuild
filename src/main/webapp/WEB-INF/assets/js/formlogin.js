

document.addEventListener('DOMContentLoaded', function() {
	
    function validateUsername() {
        var username = document.getElementById("username").value;
        var usernameError = document.getElementById("usernameError");
        var usernamePattern = /^(?=.*\d)(?=.*[\W_]).{5,}$/;
		
		if (username.trim() === "") {
		           usernameError.textContent = "Informazione obbligatoria.";
		           return false;
		       } else if (!usernamePattern.test(username)) {
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

		if (password.trim() === "") {
		            passwordError.textContent = "Informazione obbligatoria.";
		            return false;
		        } else if (!passwordPattern.test(password)) {
		            passwordError.textContent = "La password deve contenere almeno 1 lettera maiuscola, 1 lettera minuscola, 1 numero, 1 carattere speciale e deve essere di almeno 8 caratteri.";
		            return false;
		        } else {
		            passwordError.textContent = "";
		            return true;
		        }
    }

    function validateLoginForm() {
        var isUsernameValid = validateUsername();
        var isPasswordValid = validatePassword();
        return isUsernameValid && isPasswordValid;
    }

    document.getElementById("username").addEventListener("keyup", validateUsername);
    document.getElementById("password").addEventListener("keyup", validatePassword);

    document.querySelector("form").addEventListener('submit', function(event) {
        if (!validateLoginForm()) {
            event.preventDefault();
        }
    });
});



function togglePassword() {
    var password = document.getElementById("password-field");
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
