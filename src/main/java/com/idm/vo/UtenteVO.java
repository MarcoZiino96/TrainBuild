package com.idm.vo;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UtenteVO {

		@NotBlank(message = "nome obbligatorio")
		@Size(min = 2, max = 20, message = "Il nome deve avere tra 2 e 20 caratteri")
	    private String nome;

	    @NotBlank(message = "cognome obbligatorio")
	    @Size(min = 2, max = 20, message = "Il cognome deve avere tra 2 e 20 caratteri")
	    private String cognome;

	    @NotBlank(message = "username obbligatorio")
	    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.]).{5,}$",
        message = "Username deve contenere: 1 numero, 1 carattere speciale, Min 5 caratteri")
	    private String username;

	    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email non valida")
	    private String email;

	    @NotBlank(message = "Password obbligatoria")
	    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.]).{8,}$",
	            message = "Password deve contenere: 1 lettera maiuscola, 1 lettera minuscola, 1 numero, 1 carattere speciale, Min 8 caratteri")
	    private String password;

	    @NotEmpty(message = "data di nascita obbligatoria")
	    private String dataNascita;
	    
	    public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getDataNascita() {
			return dataNascita;
		}

		public void setDataNascita(String dataNascita) {
			this.dataNascita = dataNascita;
		}
}
