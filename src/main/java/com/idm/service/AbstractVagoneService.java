package com.idm.service;

import org.springframework.transaction.annotation.Transactional;

import com.idm.abstractClasses.AbstractVagone;



public interface AbstractVagoneService {
	
	
	public AbstractVagone create(AbstractVagone abstractVagone);
}
