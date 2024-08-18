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

	public  Prenotazione creaPrenotazione( PrenotazioneVO pr) {

		Treno treno = trenoService.find(pr.getTrenoId());
		Utente utente = utenteService.find(pr.getUtenteId());

		try {
			exsistingPrenotazione(utente.getId(), treno.getId());
		}catch (IllegalStateException e) {
			throw e;
		}
		List<TrenoVO> treni = findTreniConVagonePasseggeri();
		VagonePasseggeri vagone = findPrimoVagonePasseggeriDisponibile(treni);
		if (vagone == null) {
			throw new IllegalStateException("Nessun vagone passeggeri disponibile");
		}

		vagone.prenotaPosto();
		abstractVagoneService.create(vagone);
		Prenotazione p = new Prenotazione();
		p.setUtente(utente);
		p.setTreno(treno);
		p.setCoordinatePosto(generaCoordinatePosto(vagone));
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
		pOld.setUtente(p.getUtente());
		pOld.setTreno(p.getTreno());
		prenotazioneDao.update(pOld);
		return pOld;
	}

	public  void deletePrenotazione(int id) {
		prenotazioneDao.delete(id);	
	}

	private List<TrenoVO> findTreniConVagonePasseggeri() {
		return trenoService.findTreniConVagonePasseggeri();
	}

	public VagonePasseggeri findPrimoVagonePasseggeriDisponibile(List<TrenoVO> treni) {
		for (TrenoVO treno : treni) {
			for (AbstractVagone vagone : treno.getVagoni()) {
				if (vagone instanceof VagonePasseggeri) {
					return (VagonePasseggeri) vagone;
				}
			}
		}
		return null; 
	}


	private String generaCoordinatePosto(VagonePasseggeri vagone) {
		int numeroPosto = vagone.getNumeroPosti() - vagone.getPostiDisponibili() + 1;
		int idVagone = vagone.getId();
		return calcolaCoordinatePosto(numeroPosto, idVagone);
	}


	private String calcolaCoordinatePosto(int numeroPosto, int idVagone){

		int postiPerRiga = 8;
		int riga = (numeroPosto -1) / postiPerRiga;

		int colonna = (numeroPosto -1) % postiPerRiga + 1;
		char letteraRiga = (char) ('A' + riga);
		return letteraRiga + Integer.toString(colonna) + "-"+ "Vagone-" + idVagone;

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
}

