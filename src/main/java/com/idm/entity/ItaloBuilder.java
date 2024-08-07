package com.idm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.abstractClasses.TrenoBuilderAbstract;

@Component
public class ItaloBuilder extends TrenoBuilderAbstract {
	
	 @Autowired
	    private VagoneRistorante vagoneRistorante;

	    @Autowired
	    private Locomotiva locomotiva;

	   @Autowired
	    private VagonePasseggeri vagonePasseggeri;

       @Autowired
	    private VagoneCargo vagoneCargo;
	       

	    @Override
	    protected AbstractVagone getCostruisciVagoneCargo() {
	    	
	        return vagoneCargo;
	    }

	    @Override
	    protected AbstractVagone getCostruisciLocomotiva() {
	        return locomotiva;
	    }

	    @Override
	    protected AbstractVagone getCostruisciVagoneRistorante() {
	        return vagoneRistorante;
	    }

	    @Override
	    protected AbstractVagone getCostruisciVagonePasseggieri() {
	        return vagonePasseggeri;
	    }


}
