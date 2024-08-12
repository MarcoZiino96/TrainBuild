package com.idm.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.config.Beans;
import com.idm.dao.AbstractVagoneDao;
import com.idm.dao.TrenoDao;
import com.idm.dao.impl.AbstractVagoneDaoImpl;
import com.idm.entity.Factory;
import com.idm.entity.FrecciaRossaBuilder;
import com.idm.entity.ItaloBuilder;
import com.idm.entity.TreNordBuilder;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.entity.Utente;
import com.idm.entity.Voto;
import com.idm.exception.CargoException;
import com.idm.exception.LocomotivaException;
import com.idm.exception.RistoranteException;
import com.idm.exception.StringaException;
import com.idm.service.AbstractVagoneService;
import com.idm.service.TrenoFilterService;
import com.idm.service.TrenoService;
import com.idm.vo.TrenoVO;




@Component
public class TrenoServiceImpl implements TrenoService {

	@Autowired
	private TrenoDao trenoDao;
	@Autowired
	private FrecciaRossaBuilder frecciaRossaBuilder;
	@Autowired
	AbstractVagoneDao abstractVagoneDaoImpl;
	@Autowired
	private ItaloBuilder italoBuilder;
	@Autowired
	private TreNordBuilder treNordBuilder; 
	@Autowired     
	private TrenoFilterService trenoFilterService;

	public Treno find(Integer id) {
		Treno trenoFind = trenoDao.find(id)
;
		return trenoFind;
	}


	@Override
	public Treno createTreno(String string, Factory compagnia, Utente utente) {
	   
	    Treno treno;
	    
	    try {
	        treno = selectFactory(string, compagnia);
	    } catch (StringaException | LocomotivaException | CargoException | RistoranteException e) {
	      
	        throw e;
	    }

	    try {
	        
	        Treno trenoSaved = trenoDao.create(treno);

	        
	        for (AbstractVagone vagone : treno.getVagoni()) {
	            vagone.setTreno(trenoSaved); 
	            abstractVagoneDaoImpl.add(vagone);
	        }

	       
	        double prezzoTreno = treno.getVagoni().stream()
	                .mapToDouble(AbstractVagone::getPrezzo) 
	                .sum();

	        double lunghezzaTreno = treno.getVagoni().stream()
	                .mapToDouble(AbstractVagone::getLunghezza) 
	                .sum();

	        double pesoTreno = treno.getVagoni().stream()
	                .mapToDouble(AbstractVagone::getPeso) 
	                .sum();
	        
	        

	        trenoSaved.setPrezzo(prezzoTreno);
	        trenoSaved.setLunghezza(lunghezzaTreno);
	        trenoSaved.setPeso(pesoTreno);
	        trenoSaved.setSigla(string);
	        trenoSaved.setUtente(utente);
	        trenoSaved.setCompagnia(compagnia);

	    
	        update(trenoSaved, trenoSaved.getId());

	    } catch (RuntimeException e) {
	        
	        throw new RuntimeException("Errore durante la persistenza del treno: " + e.getMessage(), e);
	    }

	    return treno;
	}
	
	
	public Treno createTrenoProva(String string, Factory compagnia){

		 Treno treno;
		    
		    try {
		        treno = selectFactory(string, compagnia);
		    } catch (StringaException | LocomotivaException | CargoException | RistoranteException e) {
		      
		        throw e;
		    }

		    
		   
  
		        double prezzoTreno = treno.getVagoni().stream()
		                .mapToDouble(AbstractVagone::getPrezzo) 
		                .sum();

		        double lunghezzaTreno = treno.getVagoni().stream()
		                .mapToDouble(AbstractVagone::getLunghezza) 
		                .sum();

		        double pesoTreno = treno.getVagoni().stream()
		                .mapToDouble(AbstractVagone::getPeso) 
		                .sum();

		        treno.setPrezzo(prezzoTreno);
		        treno.setLunghezza(lunghezzaTreno);
		        treno.setPeso(pesoTreno);
		        treno.setSigla(string);
		        treno.setCompagnia(compagnia);

		    return treno;
	}

	public Treno update(Treno treno,int id) {

		Treno treno1 = find(treno.getId());
		treno1.setSigla(treno.getSigla());
		treno1.setCompagnia(treno.getCompagnia());
		treno1.setUtente(treno.getUtente());
		treno1.setLunghezza(treno.getLunghezza());
		treno1.setPeso(treno.getPeso());
		treno1.setPrezzo(treno.getPrezzo());

		trenoDao.update(treno1);
		return treno1;
	}


	public void delete(Treno treno) {

		trenoDao.delete(treno);
	}

	public void delete(Integer id) {

		trenoDao.delete(id)
;
	}

	public List<Treno> retrive() {
		List<Treno> u = trenoDao.retrive();
		System.out.println(u);
		return u;
	}

	public List<Treno> retriveWithOrder(String ordine, String direction) {
		List<Treno> u = trenoDao.retriveWithOrder(ordine, direction);
		return u;
    }
	
    public List<TrenoVO> retriveWithOrderVO(String ordine, String direction) {
    	List<Treno> u = trenoDao.retriveWithOrder(ordine, direction);
    	List<TrenoVO> trenoVOs = new ArrayList<>();
    	for (Treno treno : u) {
<<<<<<< HEAD
    		
    		double mediaVoti = treno.getVoti().stream()
	        		.mapToInt(Voto::getVoto)
	        		.average()
	        		.orElse(0.0);	
            vo.setId(treno.getId());
            vo.setPrezzo(treno.getPrezzo());
            vo.setPeso(treno.getPeso());
            vo.setLunghezza(treno.getLunghezza());
            vo.setSigla(treno.getSigla());
            vo.setCompagnia(treno.getCompagnia());
            vo.setUtente(treno.getUtente());

            vo.setMediaVoti(Math.round(mediaVoti * 10.0) / 10.0);
            
    	
            trenoVOs.add(vo);
    	}    	
    	return trenoVOs;
    }
    
    public Treno selectFactory(String sigla, Factory compagnia) {
        switch(compagnia) {
            case FR:
                return frecciaRossaBuilder.creaTreno(sigla);
            case IT:
                return italoBuilder.creaTreno(sigla);
            case TN:
                return treNordBuilder.creaTreno(sigla);
            default:
                throw new IllegalArgumentException("Compagnia non supportata: " + compagnia);
        }

    }    
}
    	
 
