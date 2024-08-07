package com.idm.dao;

import java.util.List;

import org.springframework.stereotype.Component;


import com.idm.entity.Utente;



public interface UtenteDao {
	public Utente find(Integer id);
	public Utente create(Utente ref);
	public Utente update(Utente ref);
	public void delete(Utente ref);
	public void delete(int id);
	public List<Utente> retrive();
	public Utente findByUsername(String username);
	public Utente findByEmail(String email);
	public List<Utente> searchByUsername(String username);
	public List<Utente> getAllUsers();	
	
	
}
