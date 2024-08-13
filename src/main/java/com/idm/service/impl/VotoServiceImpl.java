package com.idm.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.idm.dao.VotoDao;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.entity.Voto;
import com.idm.service.TrenoService;
import com.idm.service.UtenteService;
import com.idm.service.VotoService;
import com.idm.vo.VotoVO;

@Component
public class VotoServiceImpl implements VotoService {

	@Autowired
	private VotoDao votoDao;
	
	@Autowired 
	TrenoService  trenoService;
	
	@Autowired 
	UtenteService utenteService;
	
	
	public  Voto findVoto(int id) {

		Voto p = votoDao.find(id);
		if(p == null)
			throw new RuntimeException("Voto non trovato!!!");

		return p;
	}

	public  Voto creaVoto( Voto voto) {	
		Voto v = new Voto();
		v.setTreno(voto.getTreno());
		v.setUtente(voto.getUtente());
		v.setVoto(voto.getVoto());
		votoDao.add(v);
		return v;
		
	}

	public  void deleteVoto(int id) {
		Voto voto = findVoto(id);
		votoDao.delete(voto.getId());	
	}

	@Override
	public Voto updateVoto(Voto voto, int id) {
		Voto vOld = findVoto(id);
		vOld.setTreno(voto.getTreno());
		vOld.setUtente(voto.getUtente());
		vOld.setVoto(voto.getVoto());
		votoDao.update(vOld);
		return vOld;
	}


	@Override
	public Voto votoEstistente(Integer utente, Integer treno) {
		return votoDao.votoEsistente(utente, treno);
	}
	
	public Voto salvaOUpdateVoto(VotoVO votoVo) {
		
		Voto exsistingVoto = votoEstistente(votoVo.getUtenteId(), votoVo.getTrenoId());
		Utente utente = utenteService.find(votoVo.getUtenteId());
		Treno treno = trenoService.find(votoVo.getTrenoId());
		Voto voto;
			if(exsistingVoto == null){
				 voto = new Voto();
				voto.setUtente(utente);
				voto.setTreno(treno);
				BeanUtils.copyProperties(votoVo, voto, "id");
				creaVoto(voto);		
			}else {
				 voto = new Voto();
				voto.setVoto(votoVo.getVoto());
				voto.setUtente(exsistingVoto.getUtente());  
			    voto.setTreno(exsistingVoto.getTreno());
			    System.out.println(voto);
				BeanUtils.copyProperties(votoVo, voto, "id");		     
				Voto votoUpdate = updateVoto(voto, exsistingVoto.getId());	
			}
			return voto;
}
	
}
