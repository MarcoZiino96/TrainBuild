package com.idm.service;

import java.util.List;

import com.idm.entity.Factory;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.vo.TrenoVO;



public interface TrenoService {
	public Treno find(Integer id);
	public Treno createTreno(String string, Factory compagnia, Utente utente);
	public Treno createTrenoProva(String string, Factory compagnia);
	public Treno update(Treno treno);
	public void delete(Treno treno);
	public void delete(Integer id);
	public List<Treno> retrive();
	public List<TrenoVO> retriveWithOrderVO(String ordine, String direction);


}
