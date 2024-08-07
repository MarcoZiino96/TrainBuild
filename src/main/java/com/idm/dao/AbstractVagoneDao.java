package com.idm.dao;
import org.springframework.transaction.annotation.Transactional;
import com.idm.abstractClasses.AbstractVagone;



public interface  AbstractVagoneDao  {
	@Transactional
	public AbstractVagone add(AbstractVagone vc);
}
