package com.idm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.config.Beans;
import com.idm.dao.AbstractVagoneDao;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.entity.VagoneRistorante;
import com.idm.service.AbstractVagoneService;

public class AbstractVagoneServiceImpl implements AbstractVagoneService{
	
	@Autowired
	private AbstractVagoneDao abtsractVagoneDao;

	public AbstractVagone create(AbstractVagone  abstractVagone) {
		AbstractVagone va = abtsractVagoneDao.add(abstractVagone);
		return va;
	}
	
	
}
