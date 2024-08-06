package com.idm.dao.impl;


import javax.persistence.*;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.entity.VagoneRistorante;


@Component
public class VagoneRistoranteDaoImpl extends DaoImpl implements VagoneRistoranteDao {

	@PersistenceContext
	private EntityManager manager;


	@Override
	@Transactional
	public VagoneRistorante add(VagoneRistorante vr) {
		manager.persist(vr);
		return vr;
	}
	
	@Override
	@Transactional
	public VagoneRistorante update(VagoneRistorante vr) {
		manager.merge(vr);
		return vr;
	}

	@Override
	@Transactional
	public void delete(int id) {

		VagoneRistorante vr = this.find(id);
		if(vr != null)
			manager.remove(vr);
	}

	@Override
	public VagoneRistorante find(Integer id) {
		return manager.find(VagoneRistorante.class, id );
	}
	
}


