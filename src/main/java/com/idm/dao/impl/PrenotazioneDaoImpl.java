package com.idm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idm.dao.PrenotazioneDao;
import com.idm.entity.Prenotazione;
import com.idm.entity.VagonePasseggeri;

@Component
public class PrenotazioneDaoImpl extends DaoImpl implements PrenotazioneDao{

	@PersistenceContext
	private EntityManager manager;


	@Override
	@Transactional
	public Prenotazione add(Prenotazione p) {
		manager.persist(p);
		return p;
	}
	
	@Override
	@Transactional
	public void update(Prenotazione p) {
		manager.merge(p);
	}

	@Override
	@Transactional
	public void delete(int id) {

		Prenotazione p = this.find(id);
		if(p != null)
			manager.remove(p);
	}

	@Override
	public Prenotazione find(Integer id) {
		return manager.find(Prenotazione.class, id );
	}
	
	public Prenotazione exsistingPrenotazione(int utenteId, int trenoId) {
		Query query = manager.createQuery
		("SELECT p FROM Prenotazione p WHERE  p.utente.id = :utenteId AND p.treno.id = :trenoId", Prenotazione.class);
		query.setParameter("utenteId", utenteId);
		query.setParameter("trenoId", trenoId);
		return (Prenotazione)query.getSingleResult();
	}

	
}
