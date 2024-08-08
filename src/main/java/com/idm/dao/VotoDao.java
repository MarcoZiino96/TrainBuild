package com.idm.dao;

import org.springframework.stereotype.Component;

import com.idm.entity.Prenotazione;
import com.idm.entity.Utente;
import com.idm.entity.Voto;
import com.idm.vo.VotoVO;

@Component
public interface VotoDao {
	
public Voto add(Voto p);
	
	public Voto update(Voto p);

	public Voto find(Integer id);
	
	public void delete(int id);
	
	public Voto votoEsistente(Integer utenteId,Integer trenoId);
	
	
	
	
}
