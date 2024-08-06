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

	@Override
	public Voto findByTrenoAndUtente(int trenoId, int utenteId) {
		TypedQuery<Voto> query = manager.createQuery(
				"SELECT v FROM Voto v WHERE v.treno.id = :trenoId AND v.utente.id = :utenteId", Voto.class);
		query.setParameter("trenoId", trenoId);
		query.setParameter("utenteId", utenteId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null; // Return null if no result found
		}
	}
}
