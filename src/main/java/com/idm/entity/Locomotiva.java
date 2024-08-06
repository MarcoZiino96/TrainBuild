package com.idm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;

@Entity
@Table(name = "locomotiva")
@Component
public class Locomotiva extends AbstractVagone {
	
	private String potenza;
	
	public Locomotiva() {
		
	}
	
	


	public Locomotiva(String potenza,double lunghezza, double peso, double prezzo) {
		super(lunghezza, peso, prezzo);
		this.potenza = potenza;
	}




	public String getPotenza() {
		return potenza;
	}

	public void setPotenza(String potenza) {
		this.potenza = potenza;
	}

	@Override
	public String toString() {
		return 
				"Locomotiva [potenza=" + potenza + super.toString() +
				"]"   ;
	}
	
}
