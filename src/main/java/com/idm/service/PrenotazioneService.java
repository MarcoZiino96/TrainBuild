package com.idm.service;

import com.idm.entity.Prenotazione;
import com.idm.vo.PrenotazioneVO;


public interface PrenotazioneService {
	
	public  Prenotazione creaPrenotazione( PrenotazioneVO pr);
	public  Prenotazione findPrenotazione(int id);
	public  Prenotazione updatePrenotazione(Prenotazione p, int id);
	public  void deletePrenotazione(int id);
	public Prenotazione exsistingPrenotazione(int utenteId, int trenoId);
}
