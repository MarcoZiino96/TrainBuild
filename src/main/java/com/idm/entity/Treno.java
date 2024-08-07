package com.idm.entity;
import java.util.List;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.interfaces.Bean;
import com.idm.interfaces.Vagone;


@Entity
@Table(name = "treno")
public class Treno implements Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "utente_fk")
	private Utente utente;
	private Double prezzo;
	private Double peso;
	private Double lunghezza;
	private String sigla;
	private String foto;
	private Factory compagnia;
	@OneToMany(mappedBy = "treno",cascade = CascadeType.ALL, orphanRemoval = true)
	List<AbstractVagone> vagoni;



	public List<AbstractVagone> getVagoni() {
		return vagoni;
	}

	public void setVagoni(List<AbstractVagone> vagoni) {
		this.vagoni = vagoni;
	}

	public Treno(List<AbstractVagone> vagoni) {
		super();
		this.vagoni = vagoni;
	}

	public Treno() {
	}
	 public Treno(Double prezzo, Double peso, Double lunghezza, String sigla, String foto) {
			this.prezzo = prezzo;
			this.peso = peso;
			this.lunghezza = lunghezza;
			this.sigla = sigla;
			this.foto = foto;
		}
	
	 public Treno(Factory compagnia, String foto, String sigla, Double lunghezza, Double peso, Double prezzo, Utente utente ) {
		 this.compagnia = compagnia;
		 this.foto = foto;
		 this.sigla = sigla;
		 this.lunghezza = lunghezza;
		 this.peso = peso;
		 this.prezzo = prezzo;
		 this.utente = utente;			
		}
	
	


	public int getId() {
		return id;
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

//	public Treno(Utente utente, int prezzo, Double peso, Double lunghezza, String sigla, String foto,
//			List<AbstractVagone> vagoni) {
//		this.utente = utente;
//		this.prezzo = prezzo;
//		this.peso = peso;
//		this.lunghezza = lunghezza;
//		this.sigla = sigla;
//		this.foto = foto;
//		this.vagoni = vagoni;
//	}




public void setPeso(Double peso) {
	this.peso = peso;
}


public void setLunghezza(Double lunghezza) {
	this.lunghezza = lunghezza;
}


public void getId(int id) {
	this.id = id;
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

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}



	@Override
	public String toString() {
		return "Treno [utente=" + utente + ", prezzo=" + prezzo + ", peso=" + peso + ", lunghezza=" + lunghezza
				+ ", sigla=" + sigla +  ", getUtente()=" + getUtente() + ", getSigla()="
				+ getSigla() + ", getFoto()=" + getFoto() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
