package com.idm.dao.impl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.VagonePasseggeri;

@Component
public class VagonePasseggeriDaoImpl extends DaoImpl implements VagonePasseggeriDao {

	@PersistenceContext
	private EntityManager manager;


	@Override
	@Transactional
	public VagonePasseggeri add(VagonePasseggeri vp) {
		manager.persist(vp);
		return vp;
	}
	
	@Override
	@Transactional
	public void update(VagonePasseggeri vp) {
		manager.merge(vp);
	}

	@Override
	@Transactional
	public void delete(int id) {

		VagonePasseggeri vp = this.find(id);
		if(vp != null)
			manager.remove(vp);
	}

	@Override
	public VagonePasseggeri find(Integer id) {
		return manager.find(VagonePasseggeri.class, id );
	}
	
}


