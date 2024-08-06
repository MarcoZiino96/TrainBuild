package com.idm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;

@Entity
@Table(name = "vagoneCargo")
@Component
public class VagoneCargo extends AbstractVagone{
	
	@Column(name = "capacita_massima")
	private double capacitaMassima;

	

	public VagoneCargo(double lunghezza, double peso, double prezzo, double capacitaMassima) {
		super(lunghezza, peso, prezzo);
		this.capacitaMassima = capacitaMassima;
	}



	public VagoneCargo() {
		super();
	}
	
	

	public double getCapacitaMassima() {
		return capacitaMassima;
	}

	public void setCapacitaMassima(double capacitaMassima) {
		this.capacitaMassima = capacitaMassima;
	}



	@Override
	public String toString() {
		return 
				 
				"VagoneCargo [capacitaMassima=" + capacitaMassima 
				+ super.toString() + "]";
	}



	

	

	
	
	

}
