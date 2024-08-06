package com.idm.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PrenotazioneVO {
	@NotNull
    private Integer id;

    @NotNull
    private LocalDate dataAttivazione;

    @NotNull
    private LocalDate dataPartenza;

    @NotNull
    @Size(min = 1, max = 80)
    private String coordinatePosto;

    @NotNull
    private Integer utenteId;

    @NotNull
    private Integer trenoId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "PrenotazioneVo [id=" + id + ", dataAttivazione=" + dataAttivazione + ", dataPartenza=" + dataPartenza
				+ ", coordinatePosto=" + coordinatePosto + ", utenteId=" + utenteId + ", trenoId=" + trenoId + "]";
	}
	

}
