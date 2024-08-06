package com.idm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idm.dao.VotoDao;
import com.idm.entity.Voto;

@Component
public class VotoDaoImpl extends DaoImpl implements VotoDao{

	@PersistenceContext
	private EntityManager manager;


	@Override
	@Transactional
	public Voto add(Voto v) {
		manager.persist(v);
		return v;
	}

	@Override
	@Transactional
	public Voto update(Voto v) {
		return manager.merge(v);
	}

	@Override
	@Transactional
	public void delete(int id) {

		Voto v = this.find(id);
		if(v != null)
			manager.remove(v);
	}

	@Override
	public Voto find(Integer id) {
		return manager.find(Voto.class, id );
	}

}
