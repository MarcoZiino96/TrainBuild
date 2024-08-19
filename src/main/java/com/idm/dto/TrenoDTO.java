package com.idm.dto;

import com.idm.entity.Factory;

public class TrenoDTO {
	
     private Integer id;
	
	private double prezzo;
	
	private double peso;
	
	private double lunghezza;
	
	private String sigla;
	
	private String foto;
	
	private Factory compagnia;
	
	private UtenteDTO utente;

	

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Factory getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(Factory compagnia) {
		this.compagnia = compagnia;
	}
}
