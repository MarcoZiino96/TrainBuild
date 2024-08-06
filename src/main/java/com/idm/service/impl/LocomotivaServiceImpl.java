package com.idm.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.idm.dao.LocomotivaDao;

import com.idm.entity.Locomotiva;
import com.idm.service.LocomotivaService;


public class LocomotivaServiceImpl{

	@Autowired
	private LocomotivaDao locomotivaDao;




	public Locomotiva find(Integer id) {
		Locomotiva locomotivaFind = locomotivaDao.find(id);
		return locomotivaFind;
	}

	public Locomotiva createLocomotiva(Locomotiva locomotiva) {
		Locomotiva locomotiva1 = new Locomotiva();
		locomotiva1.setPotenza(locomotiva.getPotenza());
		locomotiva1.setLunghezza(locomotiva.getLunghezza());
		locomotiva1.setPeso(locomotiva.getLunghezza());
		locomotiva1.setPrezzo(locomotiva.getPrezzo());

		locomotiva1 = locomotivaDao.create(locomotiva1);
		return locomotiva1;
	}

	public Locomotiva update(Locomotiva locomotiva,int id) {
		Locomotiva locUpdate = find(id);

		locUpdate.setLunghezza(locUpdate.getLunghezza());
		locUpdate.setPeso(locUpdate.getPeso());
		locUpdate.setPotenza(locUpdate.getPotenza());
		locUpdate.setPrezzo(locUpdate.getPrezzo());
		locomotivaDao.update(locUpdate);
		return locUpdate;
	}

	public void delete(Locomotiva locomotiva) {
		locomotivaDao.delete(locomotiva);
	}

	public void delete(Integer id) {
		locomotivaDao.delete(id);
	}

	public List<Locomotiva> retrive() {
		List<Locomotiva> u = locomotivaDao.retrive();
		return u;
	}

}
