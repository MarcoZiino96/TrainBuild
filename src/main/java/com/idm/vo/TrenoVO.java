package com.idm.vo;

import java.util.Objects;

import com.idm.entity.Factory;
import com.idm.entity.Utente;

public class TrenoVO {
	
	private Integer id;
	private Utente utente;
	private Double prezzo;
	private Double peso;
	private Double lunghezza;
	private String sigla;
	private String foto;
	private Factory compagnia;


	
	
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(Double lunghezza) {
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
	public void setCompagnia(Factory factory) {
		this.compagnia = factory;
	}
}
