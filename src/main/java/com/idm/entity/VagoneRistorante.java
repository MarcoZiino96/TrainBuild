package com.idm.entity;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;


@Entity
@Table(name = "vagoneRistorante")
@Component
public class VagoneRistorante extends AbstractVagone {

	@Column(name = "numero_tavoli")
	private int numeroTavoli;


    
	public VagoneRistorante(double lunghezza, double peso, double prezzo, int numeroTavoli){
		super(lunghezza, peso, prezzo);
		this.numeroTavoli = numeroTavoli;
	}


	public VagoneRistorante() {
		super();
	}
	

	@Override
	public String toString() {
		return 
				 
				"VagoneRistorante [numeroTavoli=" + numeroTavoli 
				+ super.toString() + "]";
	}


	public int getNumeroTavoli() {
		return numeroTavoli;
	}

	public void setNumeroTavoli(int numeroTavoli) {
		this.numeroTavoli = numeroTavoli;
	}
	
	
	
}
