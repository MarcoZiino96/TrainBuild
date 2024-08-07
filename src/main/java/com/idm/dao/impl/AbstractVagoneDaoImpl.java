package com.idm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.idm.abstractClasses.AbstractVagone;
import com.idm.dao.AbstractVagoneDao;

@Component
public class AbstractVagoneDaoImpl extends DaoImpl implements AbstractVagoneDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public AbstractVagone add(AbstractVagone vc) {

		return manager.merge(vc);

		 
	}

}
