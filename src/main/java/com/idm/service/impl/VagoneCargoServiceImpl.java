package com.idm.service.impl;



import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.idm.config.Beans;
import com.idm.dao.VagoneCargoDao;
import com.idm.entity.VagoneCargo;
import com.idm.service.VagoneCargoService;

@Component
public class VagoneCargoServiceImpl implements VagoneCargoService {

	@Autowired
	private VagoneCargoDao vagoneCargoDao;


	@Transactional
	public VagoneCargo create(VagoneCargo vagoneCargo) {



		VagoneCargo vagoneCargoNew = new VagoneCargo();

		vagoneCargoNew .setLunghezza(vagoneCargo.getLunghezza());
		vagoneCargoNew .setPeso(vagoneCargo.getPeso());
		vagoneCargoNew .setPrezzo(vagoneCargo.getPrezzo());
		vagoneCargoNew .setCapacitaMassima(vagoneCargo.getCapacitaMassima());

		VagoneCargo vc = vagoneCargoDao.add(vagoneCargo);
		return vc;
	}

	public  VagoneCargo findVagoneCargo(int id) {

		return vagoneCargoDao.find(id);
	}

	@Transactional
	public void updateVagoneCargo(VagoneCargo vagoneCargo) {

		vagoneCargoDao.update(vagoneCargo);

	}


	@Transactional
	public  VagoneCargo updateVagoneCargo(VagoneCargo vagoneCargo, int id) {


		VagoneCargo OldVagoneCargo = findVagoneCargo(id);

		OldVagoneCargo.setLunghezza(vagoneCargo.getLunghezza());
		OldVagoneCargo.setPeso(vagoneCargo.getPeso());
		OldVagoneCargo.setPrezzo(vagoneCargo.getPrezzo());
		OldVagoneCargo.setCapacitaMassima(vagoneCargo.getCapacitaMassima());

		vagoneCargoDao.update(OldVagoneCargo);
		return(OldVagoneCargo);
	}

	@Transactional
	public  void deleteVagoneCargo(int id){

		vagoneCargoDao.delete(id);
	}


}