package com.idm.service;

import com.idm.entity.VagoneCargo;

public interface VagoneCargoService {
	public VagoneCargo create(VagoneCargo vagoneCargo);
	public  VagoneCargo findVagoneCargo(int id);
	public void updateVagoneCargo(VagoneCargo vagoneCargo);
	public  VagoneCargo updateVagoneCargo(VagoneCargo vagoneCargo, int id);
	public  void deleteVagoneCargo(int id);
}
