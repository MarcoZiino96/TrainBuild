package com.idm.dao.impl;


import javax.persistence.*;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idm.dao.VagoneCargoDao;
import com.idm.entity.VagoneCargo;


@Component
public class VagoneCargoDaoImpl extends DaoImpl implements VagoneCargoDao {

	@PersistenceContext
	private EntityManager manager;


	@Override
	@Transactional
	public VagoneCargo add(VagoneCargo vc) {
		manager.persist(vc);
		return vc;
	}
	
	@Override
	@Transactional
	public VagoneCargo update(VagoneCargo vc) {
		manager.merge(vc);
		return vc;
	}

	@Override
	@Transactional
	public void delete(int id) {

		VagoneCargo vc = this.find(id);
		if(vc != null)
			manager.remove(vc);
	}

	@Override
	public VagoneCargo find(Integer id) {
		return manager.find(VagoneCargo.class, id );
	}
	
}


