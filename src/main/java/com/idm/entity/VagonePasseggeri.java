package com.idm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;


@Entity
@Table(name = "vagonePasseggeri")
@Component
public class VagonePasseggeri extends AbstractVagone {	
	
	@Column(name = "numero_posti")
	private int numeroPosti;
	
	@Column(name = "posti_disponibili")
	private int postiDisponibili;
	 
    @OneToMany(mappedBy = "vagonePasseggeri", cascade = CascadeType.REMOVE)
	    private List<Prenotazione> prenotazioni;
	 
	 
	
	

	public int getPostiDisponibili() {
		return postiDisponibili;
	}



	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}



	public VagonePasseggeri() {
		super();
	}
	
	

	public VagonePasseggeri( double lunghezza, double peso, double prezzo, int numeroPosti) {
		super( lunghezza, peso, prezzo);
		this.numeroPosti = numeroPosti;
		 this.postiDisponibili = numeroPosti;
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
	
	 public void prenotaPosto() {
	        if (postiDisponibili > 0) {
	            postiDisponibili--;
	        } else {
	            throw new IllegalStateException("Nessun posto disponibile nel vagone");
	        }
	    }
	
	

}
