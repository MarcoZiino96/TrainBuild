package com.idm.service.impl;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.idm.converter.UtenteConverter;
import com.idm.dao.UtenteDao;
import com.idm.dto.UtenteDTO;
import com.idm.entity.Utente;
import com.idm.service.UtenteService;
import com.idm.vo.UtenteVO;

@Component
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDao utenteDao;


	public Utente find(Integer id) {
	 return utenteDao.find(id);
//		 UtenteConverter.fromDtoToVo(utenteFind);
	}

	public Utente createUtente(UtenteVO utenteDto) {
		Utente utenteNew = new Utente();
		utenteNew.setCognome(utenteDto.getCognome());
		utenteNew.setNome(utenteDto.getNome()); 
		utenteNew.setEmail(utenteDto.getEmail());
		utenteNew.setDataNascita(LocalDate.parse(utenteDto.getDataNascita())); 
		utenteNew.setPassword(utenteDto.getPassword());
		utenteNew.setUsername(utenteDto.getUsername());

//		Utente utente = UtenteConverter.fromDtoToEntity(utenteNew);
		return utenteDao.create(utenteNew);
		
	}


	public Utente update(Utente utenteDto) {

		Utente utente1 = utenteDao.find(utenteDto.getId());

		utente1.setCognome(utenteDto.getCognome());
		utente1.setDataNascita(utenteDto.getDataNascita());
		utente1.setEmail(utenteDto.getEmail());
		utente1.setNome(utenteDto.getNome());
		utente1.setUsername(utenteDto.getUsername());
		utente1.setPassword(utenteDto.getPassword());
//		UtenteConverter.fromDtoToEntity(utenteDto)
		return utenteDao.update(utente1);	 
	}


	public void delete(Utente ref) {
//		Utente utente = UtenteConverter.fromDtoToEntity(ref);
		utenteDao.delete(ref);

	}


	public void delete(int id) {
		utenteDao.delete(id);

	}

	public Utente findByUsername(String username){

	return	utenteDao.findByUsername(username);
		 
	}

	public Utente findByEmail(String email){

	return utenteDao.findByEmail(email);
	
		  
	}

	@Override
	public List<Utente> getAllUsers() {
		List<Utente> u = utenteDao.getAllUsers();
		return u;
	}

}
