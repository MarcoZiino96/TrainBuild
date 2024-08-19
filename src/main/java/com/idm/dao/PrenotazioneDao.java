package com.idm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.idm.entity.Prenotazione;

@Component
public interface PrenotazioneDao {

	public Prenotazione add(Prenotazione vp);

	public void update(Prenotazione vp);

	public Prenotazione find(Integer id);

	public void delete(int id);

	public Prenotazione exsistingPrenotazione(int utenteId, int trenoId);
	
	public List<Prenotazione> prenotazioneUtenteById(int utenteId);
}
