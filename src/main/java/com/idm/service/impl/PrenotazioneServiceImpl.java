package com.idm.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
	
	 VagonePasseggeri vagone = trovaVagoneDisponibile(treno);
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
	
	private VagonePasseggeri trovaVagoneDisponibile(Treno treno) {
        return treno.getVagoni().stream()
            .filter(vagone -> vagone instanceof VagonePasseggeri)
            .map(vagone -> (VagonePasseggeri) vagone)
            .filter(v -> v.getPostiDisponibili() > 0)
            .findFirst()
            .orElse(null);
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
		return letteraRiga + Integer.toString(colonna) + "-"+ idVagone;
		
	}
}
