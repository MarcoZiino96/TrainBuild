package com.idm.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.idm.config.Beans;
import com.idm.dao.TrenoDao;
import com.idm.dao.UtenteDao;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.service.UtenteService;
import com.idm.vo.UtenteVO;

@Component
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDao utenteDao;


	public Utente find(Integer id) {
		Utente utenteFind = utenteDao.find(id);
		System.out.println(utenteFind);
		return utenteFind;
	}



	public Utente createUtente(UtenteVO utenteVo) {
		Utente utenteNew = new Utente();
		utenteNew.setCognome(utenteVo.getCognome());
		utenteNew.setNome(utenteVo.getNome()); 
		utenteNew.setEmail(utenteVo.getEmail());
		utenteNew.setDataNascita(LocalDate.parse(utenteVo.getDataNascita())); 
		utenteNew.setPassword(utenteVo.getPassword());
		utenteNew.setUsername(utenteVo.getUsername());

		utenteDao.create(utenteNew);
		return utenteNew;
	}


	public Utente update(Utente ref,int id) {
		Utente utente = find(id);

		utente.setCognome(ref.getCognome());
		utente.setDataNascita(ref.getDataNascita());
		utente.setEmail(ref.getEmail());
		utente.setNome(ref.getNome());
		utente.setUsername(ref.getUsername());
		utente.setPassword(ref.getPassword());

		utenteDao.update(utente);

		return utente;
	}


	public void delete(Utente ref) {
		utenteDao.delete(ref);

	}


	public void delete(int id) {
		utenteDao.delete(id);

	}

	public List<Utente> retrive(){
		List<Utente> u = utenteDao.retrive();
		System.out.println(u);
		return u;
	}
	
	public Utente findByUsername(String username){
		
		return utenteDao.findByUsername(username);
	}
public Utente findByEmail(String email){
		
		return utenteDao.findByEmail(email);
	}

	public List<Utente> searchByUsername(String userName){
		List<Utente> u = utenteDao.searchByUsername(userName);
		System.out.println(u);
		return u;
	}
	@Override
	public List<Utente> getAllUsers() {
		List<Utente> u = utenteDao.getAllUsers();
		return u;
	}


}
