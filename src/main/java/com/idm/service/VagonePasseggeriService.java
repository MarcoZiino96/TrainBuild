package com.idm.service;

import com.idm.entity.VagonePasseggeri;

public interface VagonePasseggeriService {
	 public  VagonePasseggeri creaVagonePasseggeri( VagonePasseggeri vagonePasseggeri);
	 public  VagonePasseggeri findVagonePasseggeri(int id);
	 public  VagonePasseggeri updateVagonePasseggeri(VagonePasseggeri vp, int id);
	 public  void deleteVagonePasseggeri(int id);

}
