package com.idm.dao;

import org.springframework.stereotype.Component;

import com.idm.entity.Prenotazione;

@Component
public interface PrenotazioneDao {

   public Prenotazione add(Prenotazione vp);
	
	public void update(Prenotazione vp);

	public Prenotazione find(Integer id);
	
	public void delete(int id);
}
