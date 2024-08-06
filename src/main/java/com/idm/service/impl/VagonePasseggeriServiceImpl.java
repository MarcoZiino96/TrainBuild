package com.idm.service.impl;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.idm.config.Beans;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.VagonePasseggeri;
import com.idm.service.VagonePasseggeriService;


public class VagonePasseggeriServiceImpl implements VagonePasseggeriService {
	
	@Autowired
	private VagonePasseggeriDao vagonePasseggeroDao;
	
    public  VagonePasseggeri creaVagonePasseggeri( VagonePasseggeri vagonePasseggeri) {
		
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = new VagonePasseggeri();
		vp.setNumeroPosti(vp.getNumeroPosti());
		vp.setPrezzo(vagonePasseggeri.getPrezzo());
		vp.setLunghezza(vagonePasseggeri.getLunghezza());
		vp.setPeso(vagonePasseggeri.getPeso());
		vagonePasseggeroDao.add(vp);

		return vp;

	}

	public  VagonePasseggeri findVagonePasseggeri(int id) {
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = vagonePasseggeroDao.find(id);
		System.out.println(vp);
		return vp;
	}
	
	public  VagonePasseggeri updateVagonePasseggeri(VagonePasseggeri vp, int id) {
		
		VagonePasseggeri vpOld = findVagonePasseggeri(id);
		
		vpOld.setLunghezza(vp.getLunghezza());
		vpOld.setNumeroPosti(vp.getNumeroPosti());
		vpOld.setPeso(vp.getPeso());
		vpOld.setPrezzo(vp.getPrezzo());
		vagonePasseggeroDao.update(vpOld);
		return vpOld;
	}
	
	public  void deleteVagonePasseggeri(int id) {
		
		vagonePasseggeroDao.delete(id);	
	}
    
}
