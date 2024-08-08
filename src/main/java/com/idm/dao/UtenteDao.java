package com.idm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.idm.dto.UtenteDTO;
import com.idm.entity.Utente;



public interface UtenteDao {
	public UtenteDTO find(Integer id);
	public Utente create(Utente ref);
	public Utente update(Utente ref);
	public void delete(Utente ref);
	public void delete(int id);
	public UtenteDTO findByUsername(String username);
	public UtenteDTO findByEmail(String email);
	public List<Utente> getAllUsers();	
	
	
}
