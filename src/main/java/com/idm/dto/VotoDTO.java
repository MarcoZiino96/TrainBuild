package com.idm.dto;

public class VotoDTO {
	
	private Integer id;
	
	private  TrenoDTO treno;

	private  UtenteDTO utente;

	private Integer voto;

	public TrenoDTO getTreno() {
		return treno;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void setTreno(TrenoDTO treno) {
		this.treno = treno;
	}

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public Integer getVoto() {
		return voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

	

}
