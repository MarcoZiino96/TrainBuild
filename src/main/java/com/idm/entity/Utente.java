package com.idm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.idm.interfaces.Bean;

@Entity
@Table(name = "utente")
public class Utente implements Bean{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String password;
	@Column(unique = true)
	private String username;
	private String email;
	
	
	
	public Utente() {
	}

	public Utente( String nome, String cognome, LocalDate dataNascita, String username,
			String email, String password){
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.username = username;
		this.email = email;
		this.password= password;
	}
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
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

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", username=" + username + ", email=" + email + "]";
	}
	
}
