package com.idm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.abstractClasses.TrenoBuilderAbstract;

@Component
public class ItaloBuilder extends TrenoBuilderAbstract {
	
	@Autowired
    private ApplicationContext applicationContext;
	       

	    @Override
	    protected AbstractVagone getCostruisciVagoneCargo() {
	    	
	    	 return applicationContext.getBean(VagoneCargo.class);
	    }

	    @Override
	    protected AbstractVagone getCostruisciLocomotiva() {
	    	return applicationContext.getBean(Locomotiva.class);    
	                
	               
	    }

	    @Override
	    protected AbstractVagone getCostruisciVagoneRistorante() {
	    	return applicationContext.getBean(VagoneRistorante.class);
	    }

	    @Override
	    protected AbstractVagone getCostruisciVagonePasseggieri() {
	    	 return applicationContext.getBean(VagonePasseggeri.class);
	    }


}
