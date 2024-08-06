package com.idm.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class VotoVO {
	
	@NotNull
	private  Integer id;

	@NotNull
	private  Integer utenteId;

	@NotNull
	private  Integer trenoId;

	@NotNull
	@Min(1)
	@Max(5)
	private Integer voto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getVoto() {
		return voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

	@Override
	public String toString() {
		return "VotoVo [id=" + id + ", utenteId=" + utenteId + ", trenoId=" + trenoId + ", voto=" + voto + "]";
	}


}
