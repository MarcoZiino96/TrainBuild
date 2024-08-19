package com.idm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.idm.interfaces.Bean;

@Entity
public class Prenotazione implements Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="coordinate_posto")
	private String coordinatePosto;	

	@ManyToOne
	@JoinColumn(name = "utente_fk")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name="vagonePasseggeri_fk")
	private VagonePasseggeri vagonePasseggeri;

	public Prenotazione() {
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


	public VagonePasseggeri getVagonePasseggeri() {
		return vagonePasseggeri;
	}

	public void setVagonePasseggeri(VagonePasseggeri vagonePasseggeri) {
		this.vagonePasseggeri = vagonePasseggeri;
	}

	public String getCoordinatePosto() {
		return coordinatePosto;
	}

	public void setCoordinatePosto(String coordinatePosto) {
		this.coordinatePosto = coordinatePosto;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", dataAttivazione=" + ", coordinatePosto=" + coordinatePosto + ", utente=" + utente + ", vagonePasseggeri=" + vagonePasseggeri + "]";
	}


}
