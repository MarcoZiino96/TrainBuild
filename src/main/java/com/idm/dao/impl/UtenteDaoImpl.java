package com.idm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idm.dao.UtenteDao;
import com.idm.entity.Utente;

@Component
public class UtenteDaoImpl extends DaoImpl implements UtenteDao {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public Utente find(Integer id) {
		Utente t = manager.find(Utente.class, id);
		return t;
	}

	@Transactional
	@Override
	public Utente create(Utente ref) {
		manager.persist(ref);
		return ref;
	}

	@Transactional
	@Override
	public Utente update(Utente ref) {
		manager.merge(ref);
		return ref;
	}

	@Transactional
	@Override
	public void delete(Utente ref) {
		manager.remove(ref);

	}

	@Override
	public List<Utente> retrive() {
		Query q = manager.createQuery("select x from Utente x", Utente.class);
		List<Utente> l = q.getResultList();
		return l;
	}

	@Override
	@Transactional
	public void delete(int id) {
		Utente c = this.find(id); 
		if (c!=null)
			manager.remove(c);
	}

	 public Utente findByUsername(String username) {
	        try {
	            Query query = manager.createQuery("SELECT u FROM Utente u WHERE u.username = :username", Utente.class);
	            query.setParameter("username", username);
	            return (Utente) query.getSingleResult();
	        } catch (NoResultException e) {
	            e.getMessage();
	            return null;
	        }
	    }
	 
	 public Utente findByEmail(String email) {
	        try {
	            Query query = manager.createQuery("SELECT u FROM Utente u WHERE u.email = :email", Utente.class);
	            query.setParameter("email", email);
	            return (Utente) query.getSingleResult();
	        } catch (NoResultException e) {
	            e.getMessage();
	            return null;
	        }
	    }
	
	@Override
	public List<Utente> searchByUsername(String username) {
		return manager.createQuery("select u from Utente u where u.username =:searchUser",Utente.class)
				.setParameter("searchUser", username).getResultList();
		
	}	
}

	
	


