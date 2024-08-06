package com.idm.dao;

import com.idm.entity.VagoneCargo;

public interface VagoneCargoDao {
	

	public VagoneCargo add(VagoneCargo vc);
	
	public VagoneCargo update(VagoneCargo vc);

	public VagoneCargo find(Integer id);
	
	public void delete(int id);
}
