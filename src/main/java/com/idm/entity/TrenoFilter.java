package com.idm.entity;

public class TrenoFilter {

	private Integer prezzoMin = null;
	private Integer prezzoMax = null;
	private Integer pesoMin = null;
	private Integer pesoMax = null;
	private Integer lunghezzaMin = null;
	private Integer lunghezzaMax = null;
	private String siglaContains = null;
	private String utente = null;
	
	 private String termineRicerca;
	

	public Integer getPrezzoMin() {
		return prezzoMin;
	}
	public void setPrezzoMin(Integer prezzoMin) {
		this.prezzoMin = prezzoMin;
	}
	public Integer getPrezzoMax() {
		return prezzoMax;
	}
	public void setPrezzoMax(Integer prezzoMax) {
		this.prezzoMax = prezzoMax;
	}
	public Integer getPesoMin() {
		return pesoMin;
	}
	public void setPesoMin(Integer pesoMin) {
		this.pesoMin = pesoMin;
	}
	public Integer getPesoMax() {
		return pesoMax;
	}
	public void setPesoMax(Integer pesoMax) {
		this.pesoMax = pesoMax;
	}
	public Integer getLunghezzaMin() {
		return lunghezzaMin;
	}
	public void setLunghezzaMin(Integer lunghezzaMin) {
		this.lunghezzaMin = lunghezzaMin;
	}
	public Integer getLunghezzaMax() {
		return lunghezzaMax;
	}
	public void setLunghezzaMax(Integer lunghezzaMax) {
		this.lunghezzaMax = lunghezzaMax;
	}
	public String getSiglaContains() {
		return siglaContains;
	}
	public void setSiglaContains(String siglaContains) {
		this.siglaContains = siglaContains;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	
	public String getTermineRicerca() {
		return termineRicerca;
	}
	public void setTermineRicerca(String termineRicerca) {
		this.termineRicerca = termineRicerca;
	}
	
}
