package com.idm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.abstractClasses.TrenoBuilderAbstract;
import com.idm.config.Beans;
import com.idm.dao.AbstractVagoneDao;
import com.idm.dao.LocomotivaDao;
import com.idm.dao.TrenoDao;
import com.idm.dao.VagoneCargoDao;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.interfaces.Vagone;


@Component
public class FrecciaRossaBuilder extends TrenoBuilderAbstract {

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
