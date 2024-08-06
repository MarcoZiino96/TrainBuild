package com.idm.abstractClasses;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.idm.entity.Treno;
import com.idm.interfaces.Cargo;
import com.idm.interfaces.Locomotiva;
import com.idm.interfaces.Passeggeri;
import com.idm.interfaces.Ristorante;
import com.idm.interfaces.Vagone;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Component
public abstract class AbstractVagone implements Vagone{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private double lunghezza;
	@Column
	private double peso;
	@Column
	private double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "treno_fk")
	private Treno treno;

	
	public AbstractVagone() {
		
	}
	
	public AbstractVagone( double lunghezza, double peso, double prezzo, Treno treno) {
		this.lunghezza = lunghezza;
		this.peso = peso;
		this.prezzo = prezzo;
		this.treno = treno;
	}
	
	public AbstractVagone( double lunghezza, double peso, double prezzo) {
		this.lunghezza = lunghezza;
		this.peso = peso;
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public double getPeso() {
		return peso;
	}


	public double getPrezzo() {
		return prezzo;
	}





	public double getLunghezza()
	{
		return this.lunghezza;
	}


	public Treno getTreno() {
		return treno;
	}

	public void setTreno(Treno treno) {
		this.treno = treno;
	}

	@Override
	public String toString() {
		return " id=" + id + ", lunghezza=" + lunghezza + ", peso=" + peso + ", prezzo=" + prezzo +" "
				;
	}
	
}
