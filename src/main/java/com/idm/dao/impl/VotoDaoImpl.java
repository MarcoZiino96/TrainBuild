package com.idm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

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
	public void update(Voto v) {
		manager.merge(v);
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
	public Voto votoEsistente(Integer utente, Integer treno) {
		try {
			return manager.createQuery("SELECT v FROM Voto v WHERE v.utente.id = :utenteId AND v.treno.id = :trenoId", Voto.class)
					.setParameter("utenteId", utente)
					.setParameter("trenoId", treno)
					.getSingleResult();
		} catch (NoResultException e) {
			return null; 
		}

	}
}
