package com.idm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;


@Entity
@Table(name = "vagonePasseggeri")
@Component
public class VagonePasseggeri extends AbstractVagone {	
	
	@Column(name = "numero_posti")
	private int numeroPosti;
	
	

	public VagonePasseggeri() {
		super();
	}
	
	

	public VagonePasseggeri( double lunghezza, double peso, double prezzo, int numeroPosti) {
		super( lunghezza, peso, prezzo);
		this.numeroPosti = numeroPosti;
	}



	@Override
	public String toString() {
		return    
			   "VagonePasseggeri  [numeroPosti=" + numeroPosti +
				super.toString();
	            
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	
	

}
