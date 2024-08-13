package com.idm.service;

import com.idm.entity.Voto;
import com.idm.vo.VotoVO;


public interface VotoService {


	public  Voto creaVoto( Voto voto);
	public  Voto findVoto(int id);
	public  Voto updateVoto(Voto voto, int id);
	public  void deleteVoto(int id);
	public Voto votoEstistente(Integer utente, Integer treno);
	public Voto salvaOUpdateVoto(VotoVO votoVo);

}
