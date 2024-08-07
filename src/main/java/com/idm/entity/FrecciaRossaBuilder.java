package com.idm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
