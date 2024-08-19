package com.idm.service;

import java.util.List;

import com.idm.entity.Prenotazione;
import com.idm.vo.PrenotazioneVO;


public interface PrenotazioneService {
	
	public  Prenotazione creaPrenotazione( PrenotazioneVO pr, int id);
	public  Prenotazione findPrenotazione(int id);
	public  Prenotazione updatePrenotazione(Prenotazione p, int id);
	public  void deletePrenotazione(int id);
	public Prenotazione exsistingPrenotazione(int utenteId, int trenoId);
	public List<Prenotazione> prenotazioniutenteById(int utenteId);
}
