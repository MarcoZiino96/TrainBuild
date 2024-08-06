package com.idm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.idm.config.Beans;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.entity.VagoneRistorante;
import com.idm.service.VagoneRistoranteService;


public class VagoneRistoranteServiceImpl implements VagoneRistoranteService {
	
	@Autowired
	private VagoneRistoranteDao vagoneRistoranteDao;
	
	public VagoneRistorante create(VagoneRistorante vagoneRistorante) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        vagoneRistoranteDao = context.getBean(VagoneRistoranteDao.class);
		
		VagoneRistorante vagoneRistoranteNew = new VagoneRistorante();
		
		vagoneRistoranteNew.setLunghezza(vagoneRistorante.getLunghezza());
		vagoneRistoranteNew.setPeso(vagoneRistorante.getPeso());
		vagoneRistoranteNew.setPrezzo(vagoneRistorante.getPrezzo());
		vagoneRistoranteNew.setNumeroTavoli(vagoneRistorante.getNumeroTavoli());
		
		VagoneRistorante vr = vagoneRistoranteDao.add(vagoneRistorante);
		return vr;
	}
	
	public VagoneRistorante findVagoneRistorante(int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        vagoneRistoranteDao = context.getBean(VagoneRistoranteDao.class);
		
		return vagoneRistoranteDao.find(id);
	}
	
	
	public VagoneRistorante updateVagoneRistorante(VagoneRistorante vagoneRistorante, int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        vagoneRistoranteDao = context.getBean(VagoneRistoranteDao.class);
		
		VagoneRistorante OldVagoneRistorante = findVagoneRistorante(id);

		OldVagoneRistorante.setLunghezza(vagoneRistorante.getLunghezza());
		OldVagoneRistorante.setPeso(vagoneRistorante.getPeso());
		OldVagoneRistorante.setPrezzo(vagoneRistorante.getPrezzo());
		OldVagoneRistorante.setNumeroTavoli(vagoneRistorante.getNumeroTavoli());
		  
		  vagoneRistoranteDao.update(OldVagoneRistorante);
		  return(OldVagoneRistorante);
	}
	
	public void deleteVagoneRistorante(int id){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        vagoneRistoranteDao = context.getBean(VagoneRistoranteDao.class);
		 vagoneRistoranteDao.delete(id);
	}
	

}