package com.idm.service;

import java.util.List;

import com.idm.entity.Utente;
import com.idm.vo.UtenteVO;



public interface UtenteService {
	
	public Utente find(Integer id);
	public Utente createUtente(UtenteVO utente);
	public Utente update(Utente ref,int id);
	public void delete(Utente ref);
	public void delete(int id);
	public List<Utente> retrive();
	public Utente findByUsername(String userName);
	public Utente findByEmail(String email);
	public List<Utente> getAllUsers();



}
