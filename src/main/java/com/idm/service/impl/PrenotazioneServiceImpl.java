package com.idm.service.impl;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.dao.PrenotazioneDao;
import com.idm.entity.Prenotazione;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.entity.VagonePasseggeri;
import com.idm.service.AbstractVagoneService;
import com.idm.service.PrenotazioneService;
import com.idm.service.TrenoService;
import com.idm.service.UtenteService;
import com.idm.vo.PrenotazioneVO;
import com.idm.vo.TrenoVO;


@Component
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	PrenotazioneDao prenotazioneDao;	
	@Autowired
	TrenoService trenoService;
	@Autowired
	UtenteService utenteService;
	@Autowired
	AbstractVagoneService abstractVagoneService;

	public  Prenotazione creaPrenotazione( PrenotazioneVO pr, int trenoId) {
		
		try {
		Utente utente = utenteService.find(pr.getUtenteId());
		Treno treno = trenoService.find(trenoId);
		VagonePasseggeri vagone = findPrimoVagonePasseggeriDisponibile(treno);
		
		exsistingPrenotazione(utente.getId(), treno.getId());

		
		Prenotazione p = new Prenotazione();
		p.setUtente(utente);
		p.setVagonePasseggeri(vagone);
		p.setCoordinatePosto(generaCoordinatePosto(vagone));
		vagone.prenotaPosto();
		abstractVagoneService.create(vagone);
		prenotazioneDao.add(p);

		return p;
		}catch(IllegalStateException e) {
			throw e;
		}
	}

	public  Prenotazione findPrenotazione(int id) {
		Prenotazione p = prenotazioneDao.find(id);
		return p;
	}

	public  Prenotazione updatePrenotazione(Prenotazione p, int id) {
		Prenotazione pOld = findPrenotazione(id);
		pOld.setUtente(p.getUtente());
		pOld.setVagonePasseggeri(p.getVagonePasseggeri());
		prenotazioneDao.update(pOld);
		return pOld;
	}

	public  void deletePrenotazione(int id) {
		prenotazioneDao.delete(id);	
	}

	public VagonePasseggeri findPrimoVagonePasseggeriDisponibile(Treno treno) {
	        for (AbstractVagone vagone : treno.getVagoni()) {
	            if (vagone instanceof VagonePasseggeri && ((VagonePasseggeri) vagone).getPostiDisponibili() > 0) {
	                return (VagonePasseggeri) vagone;
	            }
	        }
	    
	    throw new IllegalStateException("Non ci sono posti disponibili per questo treno");
	}


	private String generaCoordinatePosto(VagonePasseggeri vagone) {
		int numeroPosto = vagone.getNumeroPosti() - vagone.getPostiDisponibili();
		int idVagone = vagone.getId();
		return calcolaCoordinatePosto(numeroPosto, idVagone);
	}


	private String calcolaCoordinatePosto(int numeroPosto, int idVagone){

		int postiPerRiga = 8;
		int riga = numeroPosto / postiPerRiga;

		int colonna = numeroPosto % postiPerRiga + 1;
			
		char letteraRiga = (char) ('A' + riga);
		return "Posto-"+ letteraRiga +  colonna + "-"+ "Vagone-" + idVagone;

	}

	@Override
	public Prenotazione exsistingPrenotazione(int utenteId, int trenoId) {
		try {
			Prenotazione prenotazione = prenotazioneDao.exsistingPrenotazione(utenteId, trenoId);
			if(prenotazione != null) {
				throw new IllegalStateException("Hai già una prenotazione per questo treno!!");
			}
			return prenotazione; 
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Prenotazione> prenotazioniutenteById(int utenteId){		
		return prenotazioneDao.prenotazioneUtenteById(utenteId);	
	}
}

