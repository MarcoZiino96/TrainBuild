package com.idm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.config.Beans;
import com.idm.dao.AbstractVagoneDao;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.entity.VagoneRistorante;
import com.idm.service.AbstractVagoneService;

@Component
public class AbstractVagoneServiceImpl implements AbstractVagoneService{
	
	@Autowired
	private AbstractVagoneDao abstractVagoneDao;
	
	@Override
	public AbstractVagone create(AbstractVagone  abstractVagone) {
		AbstractVagone va = abstractVagoneDao.add(abstractVagone);
		return va;
	}

	@Override
	public AbstractVagone update(AbstractVagone abstractVagone) {
		return abstractVagoneDao.update(abstractVagone);
	}
	
	
}
