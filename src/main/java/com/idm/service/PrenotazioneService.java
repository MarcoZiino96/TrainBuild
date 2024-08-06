package com.idm.service;

import com.idm.entity.Prenotazione;


public interface PrenotazioneService {
	
	public  Prenotazione creaPrenotazione( Prenotazione pr);
	public  Prenotazione findPrenotazione(int id);
	public  Prenotazione updatePrenotazione(Prenotazione p, int id);
	public  void deletePrenotazione(int id);
}
