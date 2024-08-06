package com.idm.dto;

public class VagonePasseggeriDTO {

	private double peso;

	private double lunghezza;

	private double prezzo;

	private String potenza;

	private int numeroPosti;

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

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getPotenza() {
		return potenza;
	}

	public void setPotenza(String potenza) {
		this.potenza = potenza;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

}
