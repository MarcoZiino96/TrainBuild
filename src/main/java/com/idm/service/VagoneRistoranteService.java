package com.idm.service;

import com.idm.entity.VagoneRistorante;

public interface VagoneRistoranteService {
	public VagoneRistorante create(VagoneRistorante vagoneRistorante);
	public VagoneRistorante findVagoneRistorante(int id);
	public VagoneRistorante updateVagoneRistorante(VagoneRistorante vagoneRistorante, int id);
	public void deleteVagoneRistorante(int id);
}
