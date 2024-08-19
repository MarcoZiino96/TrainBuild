package com.idm.vo;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PrenotazioneVO {
	@NotNull
    private Integer id;

    @NotNull
    @Size(min = 1, max = 20)
    private String coordinatePosto;

    @NotNull
    private Integer utenteId;

    @NotNull
    private Integer vagoneId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
	public Integer getVagoneId() {
		return vagoneId;
	}

	public void setVagoneId(Integer vagoneId) {
		this.vagoneId = vagoneId;
	}

	@Override
	public String toString() {
		return "PrenotazioneVo [id=" + id + ", dataAttivazione=" + coordinatePosto + ", utenteId=" + utenteId + ", trenoId=" + vagoneId + "]";
	}
	

}
