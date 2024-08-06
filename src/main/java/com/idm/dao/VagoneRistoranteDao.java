package com.idm.dao;

import org.springframework.stereotype.Component;

import com.idm.entity.VagoneRistorante;

@Component
public interface VagoneRistoranteDao {
	

	public VagoneRistorante add(VagoneRistorante vr);
	
	public VagoneRistorante update(VagoneRistorante vr);

	public VagoneRistorante find(Integer id);
	
	public void delete(int id);
}
