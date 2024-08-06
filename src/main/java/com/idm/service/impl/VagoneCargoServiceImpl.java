package com.idm.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.idm.config.Beans;
import com.idm.dao.VagoneCargoDao;
import com.idm.entity.VagoneCargo;
import com.idm.service.VagoneCargoService;


public class VagoneCargoServiceImpl implements VagoneCargoService {
	
	@Autowired
	private VagoneCargoDao vagoneCargoDao;
	
	public VagoneCargo create(VagoneCargo vagoneCargo) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        vagoneCargoDao = context.getBean(VagoneCargoDao.class);
		
		VagoneCargo vagoneCargoNew = new VagoneCargo();
		
		vagoneCargoNew .setLunghezza(vagoneCargo.getLunghezza());
		vagoneCargoNew .setPeso(vagoneCargo.getPeso());
		vagoneCargoNew .setPrezzo(vagoneCargo.getPrezzo());
		vagoneCargoNew .setCapacitaMassima(vagoneCargo.getCapacitaMassima());
		
		VagoneCargo vc = vagoneCargoDao.add(vagoneCargo);
		return vc;
	}
	
	public  VagoneCargo findVagoneCargo(int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		vagoneCargoDao  = context.getBean(VagoneCargoDao.class);
		
		return vagoneCargoDao.find(id);
	}
	
	
	public void updateVagoneCargo(VagoneCargo vagoneCargo) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		vagoneCargoDao  = context.getBean(VagoneCargoDao.class);
vagoneCargoDao.update(vagoneCargo);

	}public  VagoneCargo updateVagoneCargo(VagoneCargo vagoneCargo, int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		vagoneCargoDao  = context.getBean(VagoneCargoDao.class);
		
		VagoneCargo OldVagoneCargo = findVagoneCargo(id);

		OldVagoneCargo.setLunghezza(vagoneCargo.getLunghezza());
		OldVagoneCargo.setPeso(vagoneCargo.getPeso());
		OldVagoneCargo.setPrezzo(vagoneCargo.getPrezzo());
		OldVagoneCargo.setCapacitaMassima(vagoneCargo.getCapacitaMassima());
		  
		  vagoneCargoDao.update(OldVagoneCargo);
		  return(OldVagoneCargo);
	}
	
	
	public  void deleteVagoneCargo(int id){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		vagoneCargoDao  = context.getBean(VagoneCargoDao.class);
		 vagoneCargoDao.delete(id);
	}
	

}