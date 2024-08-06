package com.idm.service;

import com.idm.entity.Voto;
import com.idm.vo.VotoVO;


public interface VotoService {


	public  Voto creaVoto( VotoVO voto);
	public  Voto findVoto(int id);
	public  Voto updateVoto(VotoVO voto, int id);
	public  void deleteVoto(int id);
	

}
