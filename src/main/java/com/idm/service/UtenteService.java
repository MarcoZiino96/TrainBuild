package com.idm.service;

import java.util.List;

import com.idm.dto.UtenteDTO;
import com.idm.entity.Utente;
import com.idm.vo.UtenteVO;




public interface UtenteService {
	
	public UtenteVO find(Integer id);
	public Utente createUtente(UtenteDTO utente);
	public Utente update(UtenteDTO ref);
	public void delete(UtenteDTO ref);
	public void delete(int id);
	public UtenteVO findByUsername(String userName);
	public UtenteVO findByEmail(String email);
	public List<Utente> getAllUsers();



}
