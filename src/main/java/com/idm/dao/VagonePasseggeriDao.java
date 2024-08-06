package com.idm.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idm.entity.VagonePasseggeri;

@Component
public interface VagonePasseggeriDao {
	

	public VagonePasseggeri add(VagonePasseggeri vp);
	
	public void update(VagonePasseggeri vp);

	public VagonePasseggeri find(Integer id);
	
	public void delete(int id);
}
