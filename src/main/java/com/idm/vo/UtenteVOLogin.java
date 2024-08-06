package com.idm.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UtenteVOLogin {

	@NotBlank(message = "username obbligatorio")
    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.]).{5,}$",
    message = "Username deve contenere: 1 numero, 1 carattere speciale, Min 5 caratteri")
	private String username;

	 @NotBlank(message = "Password obbligatoria")
	 @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.]).{8,}$",
	          message = "Password deve contenere: 1 lettera maiuscola, 1 lettera minuscola, 1 numero, 1 carattere speciale, Min 8 caratteri")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UtenteVoLogin [Username=" + username + ", password=" + password + "]";
	}



}
