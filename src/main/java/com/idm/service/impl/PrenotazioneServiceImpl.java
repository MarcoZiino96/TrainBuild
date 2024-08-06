package com.idm.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.idm.config.Beans;
import com.idm.dao.PrenotazioneDao;
import com.idm.entity.Prenotazione;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.service.PrenotazioneService;


@Component
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	@Autowired
	PrenotazioneDao prenotazioneDao;

public  Prenotazione creaPrenotazione( Prenotazione pr) {
		
		Prenotazione p = new Prenotazione();
		p.setDataAttivazione(pr.getDataAttivazione());
		p.setDataScadenza(pr.getDataScadenza());
		p.setUtente(pr.getUtente());;
		p.setTreno(pr.getTreno());;
		prenotazioneDao.add(p);

		return p;

	}

	public  Prenotazione findPrenotazione(int id) {
		Prenotazione p = prenotazioneDao.find(id);
	System.out.println(p);
		return p;
	}
	
	public  Prenotazione updatePrenotazione(Prenotazione p, int id) {
		Prenotazione pOld = findPrenotazione(id);
		pOld.setDataAttivazione(p.getDataAttivazione());;
		pOld.setDataScadenza(p.getDataScadenza());
		pOld.setUtente(p.getUtente());
		pOld.setTreno(p.getTreno());
		prenotazioneDao.update(pOld);
		return pOld;
	}
	
	public  void deletePrenotazione(int id) {
		prenotazioneDao.delete(id);	
	}
}
