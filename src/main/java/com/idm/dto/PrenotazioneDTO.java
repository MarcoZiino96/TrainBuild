package com.idm.dto;

import java.time.LocalDate;

public class PrenotazioneDTO {
private LocalDate dataAttivazione;
	
	private LocalDate dataPartenza;
	
	private String coordinatePosto;
	
	private Integer utenteId;
	
	private Integer trenoId;


	public LocalDate getDataAttivazione() {
		return dataAttivazione;
	}


	public void setDataAttivazione(LocalDate dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}


	public LocalDate getDataPartenza() {
		return dataPartenza;
	}


	public void setDataPartenza(LocalDate dataPartenza) {
		this.dataPartenza = dataPartenza;
	}


	public String getCoordinatePosto() {
		return coordinatePosto;
	}


	public void setCoordinatePosto(String coordinatePosto) {
		this.coordinatePosto = coordinatePosto;
	}


	public Integer getUtenteId() {
		return utenteId;
	}


	public void setUtenteId(Integer utenteId) {
		this.utenteId = utenteId;
	}


	public Integer getTrenoId() {
		return trenoId;
	}


	public void setTrenoId(Integer trenoId) {
		this.trenoId = trenoId;
	}

}
