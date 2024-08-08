package com.idm.vo;

import java.util.Objects;

import com.idm.entity.Factory;
import com.idm.entity.Utente;

public class TrenoVO {
	
	private Integer id;
	private Integer utente;
	private double prezzo;
	private double peso;
	private double lunghezza;
	private String sigla;
	private Factory compagnia;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUtente() {
		return utente;
	}
	public void setUtente(Integer utente) {
		this.utente = utente;
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
	public Factory getCompagnia() {
		return compagnia;
	}
	public void setCompagnia(Factory compagnia) {
		this.compagnia = compagnia;
	}


	
	
	

	
	
}
