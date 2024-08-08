package com.idm.entity;

import javax.persistence.*;

import com.idm.interfaces.Bean;

@Entity
public class Voto implements Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "utente_fk")
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name = "treno_fk")
	private Treno treno;
	
	private int voto;
	
	
	
	
	
	public Voto() {
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Treno getTreno() {
		return treno;
	}
	public void setTreno(Treno treno) {
		this.treno = treno;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	
}
