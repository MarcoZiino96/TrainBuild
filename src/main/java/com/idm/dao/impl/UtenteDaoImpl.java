package com.idm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idm.converter.UtenteConverter;
import com.idm.dao.UtenteDao;
import com.idm.dto.UtenteDTO;
import com.idm.entity.Utente;

@Component
public class UtenteDaoImpl extends DaoImpl implements UtenteDao {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public UtenteDTO find(Integer id) {
		Utente t = manager.find(Utente.class, id);
		UtenteDTO utente = UtenteConverter.fromEntityToDto(t);
		return utente;
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
	@Transactional
	public void delete(int id) {
		UtenteDTO c = this.find(id);
		Utente utente = UtenteConverter.fromDtoToEntity(c);
		if (utente !=null)
	   manager.remove(utente);
	}

	 public UtenteDTO findByUsername(String username) {
		 
	        try {
	            Query query = manager.createQuery("SELECT u FROM Utente u WHERE u.username = :username", Utente.class);
	            query.setParameter("username", username);
	            return (UtenteDTO) query.getSingleResult();
	        } catch (NoResultException e) {
	            e.getMessage();
	            return null;
	        }
	    }
	 
	 public UtenteDTO findByEmail(String email) {
	        try {
	            Query query = manager.createQuery("SELECT u FROM Utente u WHERE u.email = :email", Utente.class);
	            query.setParameter("email", email);
	            return (UtenteDTO) query.getSingleResult();
	        } catch (NoResultException e) {
	            e.getMessage();
	            return null;
	        }
	    }
	
	@Override
	public List<Utente> getAllUsers() {
	    return manager.createQuery("SELECT u FROM Utente u", Utente.class)
	                  .getResultList();
	}
}

	
	


