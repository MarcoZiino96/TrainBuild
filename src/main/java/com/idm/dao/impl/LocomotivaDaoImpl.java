package com.idm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idm.dao.LocomotivaDao;
import com.idm.entity.Locomotiva;
import com.idm.entity.Treno;
import com.idm.entity.Utente;

@Component
public class LocomotivaDaoImpl extends DaoImpl implements LocomotivaDao {
	@PersistenceContext
	EntityManager manager;

	@Override
	public Locomotiva find(Integer id) {
		Locomotiva l = manager.find(Locomotiva.class, id);
		return l;
	}

	@Transactional
	@Override
	public Locomotiva create(Locomotiva ref) {
		manager.persist(ref);
		return ref;
	}

	@Transactional
	@Override
	public Locomotiva update(Locomotiva ref) {
		manager.merge(ref);
		return ref;
	}

	@Transactional
	@Override
	public void delete(Locomotiva ref) {
		manager.remove(ref);
		
	}

	@Transactional
	@Override
	public List<Locomotiva> retrive() {
		Query q = manager.createQuery("select x from Locomotiva x",Locomotiva.class);
		List <Locomotiva> l = q.getResultList();
		return l;
	}

	@Override
	public void delete(int id) {
		Locomotiva c = this.find(id); 
		if (c!=null)
			manager.remove(c);
		
	}
	
}
