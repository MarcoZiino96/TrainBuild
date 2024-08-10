package com.idm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.idm.config.Beans;
import com.idm.dao.VotoDao;
import com.idm.entity.Voto;
import com.idm.service.VotoService;

@Component
public class VotoServiceImpl implements VotoService {
	
	@Autowired
	VotoDao votoDao;

public  Voto creaVoto( Voto voto) {	
        Voto v = new Voto();
		v.setTreno(voto.getTreno());
		v.setUtente(voto.getUtente());
		v.setVoto(voto.getVoto());
		votoDao.add(v);

		return v;

	}

	public  Voto findVoto(int id) {
		
		Voto p = votoDao.find(id);
		if(p == null)
		throw new RuntimeException("Voto non trovato!!!");
	
		return p;
	}
	
	public  Voto updateVoto(Voto voto, int id) {
		Voto vOld = findVoto(id);
		vOld.setTreno(voto.getTreno());
		vOld.setUtente(voto.getUtente());
		vOld.setVoto(voto.getVoto());
		votoDao.update(vOld);
		return vOld;
	}
	
	public  void deleteVoto(int id) {
		Voto voto = findVoto(id);
		votoDao.delete(voto.getId());	
	}

	@Override
	public Voto votoEstistente(Integer utente, Integer treno) {
		
		 return votoDao.votoEsistente(utente, treno);
	}
}
