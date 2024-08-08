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
import com.idm.converter.UtenteConverter;
import com.idm.dao.TrenoDao;
import com.idm.dao.UtenteDao;
import com.idm.dto.UtenteDTO;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.service.UtenteService;
import com.idm.vo.UtenteVO;

@Component
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDao utenteDao;


	public UtenteVO find(Integer id) {
		UtenteDTO utenteFind = utenteDao.find(id);
		return UtenteConverter.fromDtoToVo(utenteFind);
	}

	public Utente createUtente(UtenteDTO utenteDto) {
		UtenteDTO utenteNew = new UtenteDTO();
		utenteNew.setCognome(utenteDto.getCognome());
		utenteNew.setNome(utenteDto.getNome()); 
		utenteNew.setEmail(utenteDto.getEmail());
		utenteNew.setDataNascita(utenteDto.getDataNascita()); 
		utenteNew.setPassword(utenteDto.getPassword());
		utenteNew.setUsername(utenteDto.getUsername());

		Utente utente = UtenteConverter.fromDtoToEntity(utenteNew);
		return utenteDao.create(utente);
		
	}


	public Utente update(UtenteDTO utenteDto) {

		UtenteDTO utenteDto1 = utenteDao.find(utenteDto.getId());

		utenteDto1.setCognome(utenteDto.getCognome());
		utenteDto1.setDataNascita(utenteDto.getDataNascita());
		utenteDto1.setEmail(utenteDto.getEmail());
		utenteDto1.setNome(utenteDto.getNome());
		utenteDto1.setUsername(utenteDto.getUsername());
		utenteDto1.setPassword(utenteDto.getPassword());

		Utente utente = UtenteConverter.fromDtoToEntity(utenteDto1);

		return utenteDao.update(utente);

		 
	}


	public void delete(UtenteDTO ref) {
		Utente utente = UtenteConverter.fromDtoToEntity(ref);
		utenteDao.delete(utente);

	}


	public void delete(int id) {
		utenteDao.delete(id);

	}

	public UtenteVO findByUsername(String username){

		UtenteDTO utenteDto = utenteDao.findByUsername(username);
		return UtenteConverter.fromDtoToVo(utenteDto);
	}

	public UtenteVO findByEmail(String email){

	UtenteDTO utenteDto = utenteDao.findByEmail(email);
	
		 return UtenteConverter.fromDtoToVo(utenteDto);
	}

	@Override
	public List<Utente> getAllUsers() {
		List<Utente> u = utenteDao.getAllUsers();
		return u;
	}

}
